package com.koreait.spring.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardEntity {
    private int iboard;
    private int iuser;
    private String title;
    private String ctnt;
    private String regdt;
}
