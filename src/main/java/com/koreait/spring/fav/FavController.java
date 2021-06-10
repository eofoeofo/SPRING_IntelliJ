package com.koreait.spring.fav;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController // JSP를 return 목적이 아닌 JSON을 return하려는 목적이다.
@RequestMapping("/board")
public class FavController {
    @Autowired
    private FavService service;

    @PostMapping ("/fav")
    public Map<String, Integer> insFav(@RequestBody FavDomain param){
        Map<String, Integer> result = new HashMap<>();
        result.put("result", service.insFav(param));
        return result;
    }

    @GetMapping ("/fav")
    public Map<String, Integer> selFav(FavDomain param){
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
