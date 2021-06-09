package com.koreait.spring.board;

import com.koreait.spring.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardMapper mapper;
    @Autowired
    private HttpSession session;

    public List<BoardDomain> selBoardList() {
        return mapper.selBoardList();
    }
    public BoardDomain selBoardDetail(BoardDTO param) {
        return mapper.selBoardDetail(param);
    }

    public BoardDomain delBoardDetail(BoardDomain param) {
        return mapper.delBoardDetail(param);
    }

    public BoardDomain selPagingCnt(BoardDTO param) {
        return mapper.selPagingCnt(param);
    }

    public int insBoard(BoardDomain param) {
        UserEntity loginUser = (UserEntity)session.getAttribute("loginUser");
        param.setIuser(loginUser.getIuser());
        System.out.println("iboard__write" + param.getIboard());
        return mapper.insBoard(param);
    }

    public int updBoard(BoardDomain param) {
        System.out.println("iboard__update" + param.getIboard());
        return mapper.updBoard(param);
    }

    public int delBoard(BoardDomain param) {
        UserEntity loginUser = (UserEntity)session.getAttribute("loginUser");
        param.setIuser(loginUser.getIuser());
        return mapper.delBoard(param);
    }

    public int writeMod(BoardDomain param) {
        UserEntity loginUser = (UserEntity)session.getAttribute("loginUser");
        param.setIuser(loginUser.getIuser());
        if(param.getIboard() != 0) {
            param.getIboard();
            return mapper.updBoard(param);
        }
        param.getIboard();
        return mapper.insBoard(param);
    }
}
