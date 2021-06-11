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
    // @RequestParam은 파라미터값 하나 하나씩, 받을 때 쓴다.
    // @RequestBody는 한꺼번에 받을 때 쓴다.
    @ResponseBody
    //ResponseBody을 주면 JSP파일 응답이 아닌, "JSON형태의 문자열을 객체화하는걸 목적으로 한다."
    @PostMapping("/cmt")
    public Map<String,Integer> insCmt(@RequestBody CmtEntity param) {
        Map<String, Integer> data = new HashMap<>();
        System.out.println("Ins param : " + param);
        int insCmt = service.insCmt(param);
        System.out.println("insCmt : " + insCmt);
        data.put("result" , insCmt); // {"result": 1}

        return data;
    }
    @ResponseBody
    @RequestMapping("/cmt/{iboard}")
    public List<CmtDomain> cmtSel(@PathVariable int iboard,CmtEntity param, Model model) { // 쿼리스트링으로 넘어올땐 RequsetBody를 안씀
        param.setIboard(iboard);
        System.out.println("cmtSel param : "+param);
        List<CmtDomain> list = service.selCmt(param);
        model.addAttribute("list",list);
        return list;
    }
    @ResponseBody
    @DeleteMapping("/cmt/{icmt}")
    public Map<String,Integer> cmtDel(@PathVariable int icmt,CmtEntity param) {
        param.setIcmt(icmt);
        Map<String, Integer> data = new HashMap<>();
        int cmtDel = service.delCmt(param);
        data.put("result", cmtDel);
        return data;
    }

    @ResponseBody
    @PutMapping("/cmt")
    public Map<String,Integer> CmtUpd(@RequestBody CmtEntity param) {
        Map<String, Integer> data = new HashMap<>();
        int cmtUpd = service.updCmt(param);
        System.out.println(cmtUpd);
        data.put("result",cmtUpd);
        return data;
    }
}
