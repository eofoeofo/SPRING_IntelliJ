package com.koreait.spring.cmt;

import com.koreait.spring.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class CmtService {
    @Autowired
    private CmtMapper mapper;

    @Autowired
    private HttpSession session;
    public int insCmt(CmtEntity param) {
        UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");
        param.setIuser(loginUser.getIuser());
        return mapper.insCmt(param);
    }

    public List<CmtDomain> selCmt(CmtEntity param) {
        return mapper.selCmt(param);
    }

    public int delCmt(CmtEntity param) {
        UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");
        param.setIuser(loginUser.getIuser());
        System.out.println("service DelCmt : " + param.getCmt());
        System.out.println("service Iboard : " + param.getIboard());
        System.out.println("service Iuser : " + param.getIuser());
        System.out.println("service Icmt : " + param.getIcmt());
        return mapper.delCmt(param);
    }

    public int updCmt(CmtEntity param) {
        UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");
        param.setIuser(loginUser.getIuser());
        return mapper.updCmt(param);
    }

}