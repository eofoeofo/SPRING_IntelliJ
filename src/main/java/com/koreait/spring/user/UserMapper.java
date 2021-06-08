package com.koreait.spring.user;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

@Mapper
public interface UserMapper {
    int insUser(UserEntity param);
    int delUser(UserEntity param);
    UserEntity selUser(UserEntity param);
    String uploadProfile(MultipartFile profileImg);
    int updUser(UserEntity param);
}
