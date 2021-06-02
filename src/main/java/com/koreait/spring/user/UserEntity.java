package com.koreait.spring.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString // 모든값을 담고있는것?
public class UserEntity {
    private int iuser;
    private String uid;
    private String upw;
    private String unm;
    private int gender;
    private String regdt;
    private String profileImg;
}
