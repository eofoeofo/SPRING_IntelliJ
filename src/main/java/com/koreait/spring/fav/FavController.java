package com.koreait.spring.fav;

import com.koreait.spring.board.BoardDTO;
import com.koreait.spring.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController // JSP를 return 목적이 아닌 JSON을 return하려는 목적이다.
@RequestMapping("/board")
public class FavController {
    @Autowired
    private FavService service;

    @Autowired
    private BoardService boardService;

    @PostMapping ("/fav")
    public Map<String, Integer> insFav(@RequestBody FavDomain param){ // Ajax body로 보냈을때 @RequestBody로 받아야함
        Map<String, Integer> result = new HashMap<>();
        result.put("result", service.insFav(param));
        return result;
    }

    @GetMapping("/fav") // 좋아요 리스트
    public Map<String, Object> selFavBoardList(BoardDTO param) {
        Map<String, Object> result = new HashMap();
        param.setSelType(1);
        result.put("list", boardService.selBoardList(param));
        result.put("pagingCnt",boardService.selPagingCnt(param));
        return result;
    }

    @GetMapping ("/fav/{iboard}")
    public Map<String, Integer> selFav(FavDomain param){ // Ajax 쿼리스트링으로 보냈을때 그냥 파라미터로 받으면됨
        Map<String, Integer> result = new HashMap<>();
        result.put("result", service.selFav(param));
        return result;
    }

    @DeleteMapping ("/fav")
    public Map<String, Integer> delFav(FavDomain param){
        Map<String, Integer> result = new HashMap<>();
        result.put("result", service.delFav(param));
        return result;
    }
}
