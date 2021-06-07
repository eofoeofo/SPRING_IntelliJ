package com.koreait.spring.cmt;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CmtDomain extends CmtEntity{
    private String writerNm;
}
