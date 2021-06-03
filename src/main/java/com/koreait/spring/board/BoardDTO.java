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
    private int startIdx;
    private int recordCnt;
    private int searchType;
    private String searchText;
}
