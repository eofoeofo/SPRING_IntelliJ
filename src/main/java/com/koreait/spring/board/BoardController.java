package com.koreait.spring.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService service;

    @RequestMapping("/list")
    public String list(Model model) {
        List<BoardDomain> list = service.selBoardList();
        model.addAttribute("list", list);
        return "board/list";
    }

    @RequestMapping("/detail")
    public String detail(BoardDTO param, Model model) {
        model.addAttribute("data",service.selBoardDetail(param));
        System.out.println("iboard : " + param.getIboard());
        return "board/detail";
    }

    @RequestMapping("/delete")
    public String delete(BoardDomain param) {
        service.delBoardDetail(param);
        return "board/list";
    }

}
