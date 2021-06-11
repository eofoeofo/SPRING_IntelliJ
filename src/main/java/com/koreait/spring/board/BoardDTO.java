package com.koreait.spring.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
// PARAMETER전용
public class BoardDTO {
    private int iboard;
    private int iuser;
    private int selType; // 0: 기본, 1: 좋아요 리스트
    private int page = 1; // default 1
    private int startIdx;
    private int recordCnt = 5;
    private int searchType;
    private String searchText;
}
