package com.koreait.spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service // Bean 등록(객체화 후 Bean이 갖고 있게끔 하기위해)
public class UserService{

    @Autowired
    UserMapper userMapper;


    public int insUser(UserEntity param) {
        userMapper.insUser(param);
        return 0;
    }

    public int delUser(HttpSession session) {
        UserEntity param = (UserEntity)session.getAttribute("loginUser");
        System.out.println("param__del" + param);
        userMapper.delUser(param);
        return 0;
    }

//    @Autowired
//    private UserMapper mapper;
//    public int join(UserEntity param) {
//       return mapper.insUser(param);
//    }
}
