package com.koreait.spring.cmt;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmtMapper {
    int insCmt(CmtEntity param);

    List<CmtDomain> selCmt(CmtEntity param);

    int delCmt(CmtEntity param);

    int updCmt(CmtEntity param);
}
