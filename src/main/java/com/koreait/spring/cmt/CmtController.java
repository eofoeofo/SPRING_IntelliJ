package com.koreait.spring.cmt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class CmtController {
    @Autowired
    private CmtService service;

    @ResponseBody
    //ResponseBody을 주면 JSP파일 응답이 아닌, "JSON형태의 문자열을 객체화하는걸 목적으로 한다."
    @RequestMapping(value = "/cmtIns", method = RequestMethod.POST)
    public Map<String,Integer> insCmt(@RequestBody CmtEntity param) {
        Map<String, Integer> data = new HashMap<>();
        System.out.println("Ins param : " + param);
        int insCmt = service.insCmt(param);
        System.out.println("insCmt : " + insCmt);
        data.put("result" , insCmt); // {"result": 1}

        return data;
    }
    @ResponseBody
    @RequestMapping("/cmtSel")
    public List<CmtDomain> cmtSel(CmtEntity param, Model model) { // 쿼리스트링으로 넘어올땐 RequsetBody를 안씀
        System.out.println("cmtSel param : "+param);
        List<CmtDomain> list = service.selCmt(param);
        model.addAttribute("list",list);
        return list;
    }
    @ResponseBody
    @RequestMapping("/cmtDel")
    public Map<String,Integer> cmtDel(CmtEntity param) {
        System.out.println("Del param : " + param);
        Map<String, Integer> data = new HashMap<>();
        int cmtDel = service.delCmt(param);
        System.out.println("cmtDel : " + cmtDel);
        data.put("result", cmtDel);

        return data;
    }

    @ResponseBody
    @RequestMapping(value = "/cmtUpd",method = RequestMethod.POST)
    public Map<String,Integer> CmtUpd(CmtEntity param) {
        Map<String, Integer> data = new HashMap<>();
        int cmtUpd = service.updCmt(param);
        data.put("result",1);
        return data;
    }
}
