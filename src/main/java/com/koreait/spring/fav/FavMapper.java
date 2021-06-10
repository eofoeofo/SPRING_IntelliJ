package com.koreait.spring.fav;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FavMapper {
    int insFav(FavDomain param);
    int selFav(FavDomain param);
    int delFav(FavDomain param);
}
