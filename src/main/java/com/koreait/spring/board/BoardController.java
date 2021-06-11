package com.koreait.spring.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService service;

    @RequestMapping("/list")
    public String list(BoardDTO param, Model model) {
        List<BoardDomain> list = service.selBoardList(param);
        model.addAttribute("pagingCnt",service.selPagingCnt(param));
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

    @GetMapping("/write")
    public String insBoard() {
        return "board/write";
    }

    @PostMapping("/write")
    public String insBoard(BoardDomain param) {
        param.setIuser(param.getIuser());
        System.out.println("iuser -- write "+param.getIuser());
        service.insBoard(param);
        return "redirect:/board/list";
    }

    @GetMapping("/update")
    public String updBoardGet(BoardDTO param, Model model) {
        model.addAttribute("data",service.selBoardDetail(param));
        return "board/update";
    }

    @PostMapping("/update")
    public String updBoard(BoardDomain param, Model model){
        model.addAttribute("data",service.updBoard(param));
        return "redirect:/board/list";
    }

    @GetMapping("/delete")
    public String delBoard(BoardDomain param) {
        param.setIuser(param.getIuser());
        System.out.println("iuser -- delete " + param.getIuser());
        service.delBoard(param);
        return "redirect:/board/list";
    }

    @GetMapping("/writeMod")
    public String writeMod(BoardDTO param, Model model) {
        if(param.getIboard() > 0) {
            model.addAttribute("data",service.selBoardDetail(param));
        }
        return "board/writeMod";
    }

    @PostMapping("/writeMod")
    public String writeModProc(BoardDomain param) {
        int iboard = service.writeMod(param);
        System.out.println("write iboard = " + iboard);
        System.out.println("update iboard = " + iboard);
        return "redirect:detail?iboard="+iboard;
    }

    @GetMapping("/favList")
    public void favList() {

    }
}