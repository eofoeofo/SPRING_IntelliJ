package com.koreait.spring.user;

import org.apache.commons.io.FilenameUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service // Bean 등록(객체화 후 Bean이 갖고 있게끔 하기위해)
public class UserService{

    @Autowired
    private HttpSession session;

    @Autowired
    private UserMapper mapper;


    public int insUser(UserEntity param) {
        String cryptPw = BCrypt.hashpw(param.getUpw(), BCrypt.gensalt());
        param.setUpw(cryptPw);
        return mapper.insUser(param);
    }

    public String login(UserEntity param) {
        UserEntity result = mapper.selUser(param);
        System.out.println("result : " +result.getUpw());
        System.out.println("param : " +param.getUpw());
        System.out.println("result :::::::: : " +result);
        if(result == null) { // 아이디 없음
            return "/user/login?err=1";
        } else if(BCrypt.checkpw(param.getUpw(), result.getUpw())) { // 로그인 성공
            result.setUpw(null); // 로그인 성공 후 비밀번호 NULL 처리
            // session 처리
            session.setAttribute("loginUser",result);
            return "/board/list";
        } else { // 비밀번호 틀림
            return "/user/login?err=2";
        }
    }

    public int delUser(HttpSession session) {
        UserEntity param = (UserEntity)session.getAttribute("loginUser");
        System.out.println("param__del" + param);
        return mapper.delUser(param);
    }

    public String uploadProfile(MultipartFile profileImg) {
        UserEntity loginUser = (UserEntity)session.getAttribute("loginUser");
        final String PATH = "D:/springImg/" + loginUser.getIuser(); // 파일이 저장되는 경로.

        File folder = new File(PATH);
        folder.mkdirs();

        String ext = FilenameUtils.getExtension
                (profileImg.getOriginalFilename()); // upload된 원본 파일이름
        String fileNm = UUID.randomUUID().toString() + "." + ext; // 랜덤한 파일이름 생성

        File target = new File(PATH + "/" + fileNm); //

        try {
            profileImg.transferTo(target);

            // 이전 이미지 삭제
            File delFile = new File(PATH+"/"+loginUser.getProfileImg());
            if(delFile.exists()) {
                delFile.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        UserEntity param = new UserEntity();
        param.setIuser(loginUser.getIuser());
        param.setProfileImg(fileNm);

        mapper.updUser(param);

        loginUser.setProfileImg(fileNm); // session도 변경
        return "/user/profile";
    }

//    @Autowired
//    private UserMapper mapper;
//    public int join(UserEntity param) {
//       return mapper.insUser(param);
//    }
}
