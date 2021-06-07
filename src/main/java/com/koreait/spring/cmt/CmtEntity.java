package com.koreait.spring.cmt;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CmtEntity {
    private int icmt;
    private int iboard;
    private int iuser;
    private String cmt;
    private String regdate;
}
