package com.koreait.spring.board;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    // mapper에서 #,$가 없었기 때문에 parameter값을 받지 않는다.
    List<BoardDomain> selBoardList();
}
