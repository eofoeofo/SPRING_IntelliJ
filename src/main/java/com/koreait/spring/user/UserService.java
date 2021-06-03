package com.koreait.spring.user;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service // Bean 등록(객체화 후 Bean이 갖고 있게끔 하기위해)
public class UserService{

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

//    @Autowired
//    private UserMapper mapper;
//    public int join(UserEntity param) {
//       return mapper.insUser(param);
//    }
}
