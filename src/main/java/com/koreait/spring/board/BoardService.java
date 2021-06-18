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

    public List<BoardDomain> selBoardList(BoardDTO param) {
        param.setIuser(myUtils.getLoginUserPk());
        if(param.getPage() == 0){
            param.setPage(1);
        }
        int startIdx = (param.getPage() - 1) * param.getRecordCnt();
        param.setStartIdx(startIdx);
        param.setRecordCnt(param.getRecordCnt());
        return mapper.selBoardList(param);

//        if(param.getSelType() !=0 && param.getSearchText() != null  )
    }
    public BoardDomain selBoardDetail(BoardDTO param) {
        return mapper.selBoardDetail(param);
    }

    public BoardDomain delBoardDetail(BoardDomain param) {
        return mapper.delBoardDetail(param);
    }

    public int selPagingCnt(BoardDTO param) {
        System.out.println(mapper.selPagingCnt(param));
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
