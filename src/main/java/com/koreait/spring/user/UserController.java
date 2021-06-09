package com.koreait.spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

// bean 등록중 하나인 Controller, 주소값과 매핑되는 bean
// Controller는 servlet으로부터 연결이 되는 곳
// controller는 mapping담당 // service는 logic담당
@Controller
@RequestMapping("/user") // (결국 servlet과 mapping되는 곳)
                            // class위에 RequestMapping은 전체의 1차 주소값이다.
public class UserController {

    @Autowired // 주소값을 가져오는 방법중 하나
    // Bean은 싱글톤개념이라서 Autowired는 하나의 객체만 가지고 올 수 있다.(2개이상이면 에러)
//    @Qualifier // 만약 Bean등록이 2개이상 되어있을 경우에 사용할 수 있는 어노테이션
    private UserService service;
    // service에서 bean등록 후 Autowired를 사용하면 자동으로 주소값이 들어온다.

    @RequestMapping("/login")
    // GET방식은 default값이다, 그러니 POST를 사용하려면 작성해야한다.
    // RequestParam은 jsp에서 getParameter, 쿼리스트링으로 무조건 줘야함?
    // 강제성이 있음 , 강제성을 해제하는법은 required = false, defaultValue = "0"
    public String login(@RequestParam(value="err", defaultValue = "0") int err, Model model) {
            switch (err) {
                case 1:
                    model.addAttribute("errMsg","아이디를 확인해 주세요.");
                    System.out.println("err : " + err);
                    break;
                case 2:
                    model.addAttribute("errMsg","비밀번호를 확인해 주세요.");
                    System.out.println("err : " + err);
                    break;
            }
        return "user/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    // 같은 주소값, 다른 결과값(GET,POST)
    public String login(UserEntity param)
    {
        return "redirect:"+service.login(param);
    }
    // return redirect 하지 않는 이상 자동으로 "dispatcherServlet"이 forwarding호출 된다.

    @RequestMapping("/join")
    public String join() { return "user/join"; }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String join(UserEntity param) {
        System.out.println("param : "+param);
        service.insUser(param);
        return "redirect:/user/login";
    }
    @RequestMapping("/del")
    public String joinDel(HttpSession session){
        service.delUser(session);
        return "redirect:/user/login";
    }
    @GetMapping("/profile")
    public String profile() {
        return "user/profile";
    }

//    @ResponseBody
    @PostMapping("/profile")
    public String profile(MultipartFile profileImg) { // view에서의 file형식은 MultipartFile을 통해서만 전송된다
        return "redirect:" + service.uploadProfile(profileImg);
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, HttpServletRequest request) {
        session.invalidate();
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
        // 로그아웃을 시도했을 당시의 페이지로 돌아가게끔 구현.
        //return "redirect:/user/login";
    }

}
