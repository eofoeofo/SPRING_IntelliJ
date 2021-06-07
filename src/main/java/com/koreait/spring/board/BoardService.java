package com.koreait.spring.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardMapper mapper;

    public List<BoardDomain> selBoardList() {
        return mapper.selBoardList();
    }
    public BoardDomain selBoardDetail(BoardDTO param) {
        return mapper.selBoardDetail(param);
    }

    public BoardDomain delBoardDetail(BoardDomain param) {
        return mapper.delBoardDetail(param);
    }

}
