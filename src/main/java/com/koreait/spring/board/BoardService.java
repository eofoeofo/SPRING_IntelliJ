package com.koreait.spring.board;

import com.koreait.spring.MyUtils;
import com.koreait.spring.cmt.CmtDomain;
import com.koreait.spring.cmt.CmtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardMapper mapper;
    @Autowired
    private CmtMapper cmtMapper;
    @Autowired
    private MyUtils myUtils;

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
        param.setIuser(myUtils.getLoginUserPk());
        System.out.println("iboard__write" + param.getIboard());
        return mapper.insBoard(param);
    }

    public int updBoard(BoardDomain param) {
        System.out.println("iboard__update" + param.getIboard());
        return mapper.updBoard(param);
    }

    public int delBoard(BoardDomain param) {
        CmtDomain cmtParam = new CmtDomain();
        cmtParam.setIboard(param.getIboard());
        cmtMapper.delCmt(cmtParam);

        param.setIuser(myUtils.getLoginUserPk());
        return mapper.delBoard(param);
    }

    public int writeMod(BoardDomain param) {
        param.setIuser(myUtils.getLoginUserPk());

        if(param.getIboard() == 0) {
            mapper.insBoard(param);
        } else {
            mapper.updBoard(param);
        }
        return param.getIboard();
    }
}
