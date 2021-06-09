package com.koreait.spring.board;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    // mapper에서 #,$가 없었기 때문에 parameter값을 받지 않는다.
    List<BoardDomain> selBoardList();
    // Mapper에선 xml의 BoardDomain resultType을 타입으로 준다.
    BoardDomain selBoardDetail(BoardDTO param);

    BoardDomain delBoardDetail(BoardDomain param);

    BoardDomain selPagingCnt(BoardDTO param);

    int insBoard(BoardDomain param);

    int updBoard(BoardDomain param);

    int delBoard(BoardDomain param);

    int writeMod(BoardDomain param);

}
