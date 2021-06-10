package com.koreait.spring.fav;

import com.koreait.spring.board.BoardEntity;
import lombok.Data;

@Data
public class FavDomain extends BoardEntity {
    private int isFav;
}
