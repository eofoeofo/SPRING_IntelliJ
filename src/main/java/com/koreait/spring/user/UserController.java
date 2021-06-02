package com.koreait.spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

// bean 등록중 하나인 Controller, 주소값과 매핑되는 bean
// Controller는 servlet으로부터 연결이 되는 곳
// controller는 mapping담당 // service는 logic담당
@Controller
@RequestMapping("/user") // (결국 servlet과 mapping되는 곳)
                            // class위에 RequestMapping은 전체의 1차 주소값이다.
public class UserController {

    @Autowired // 주소값을 가져오는 방법중 하나
    private UserService service;
    // service에서 bean등록 후 Autowired를 사용하면 자동으로 주소값이 들어온다.

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    // GET방식은 default값이다, 그러니 POST를 사용하려면 작성해야한다.
    
    public String login(Model model) {
        model.addAttribute("data","안녕핫세요");
        return "user/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    // 같은 주소값, 다른 결과값(GET,POST)
    public String login2() {
        return "user/login2";
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

}
