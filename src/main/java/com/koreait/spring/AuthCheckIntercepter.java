package com.koreait.spring;

import com.koreait.spring.user.UserEntity;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthCheckIntercepter implements HandlerInterceptor {
    // GET만 처리함, POST는 어차피 시도할 당시에 에러나기때문(하지만 POST도 처리는 가능하다)
//    private final String[] needLoginUriArr = {"/board/writeMod", "/board/favList", "/user/profile"};
    // Controller로 보내기 전에 처리 / false를 주면 controller에 도달하지 않게됨
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }
    // Controller에 간 뒤(메소드까지 가서 return을 받아온 상태),
    // (view에 도달하기 직전) handler가 끝나면 처리하는 구간
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        String uri = request.getRequestURI();
        System.out.println("uri : " + uri);

//        if(Arrays.asList(needLoginUriArr).contains(uri)) { // 만약 needLoginUriArr의 주소값이 존재한다면 로그인이 필요하다는 뜻.
            UserEntity loginUser = (UserEntity) request.getSession().getAttribute("loginUser");

            if(loginUser == null) { //
                System.out.println("viewName  : " + modelAndView.getViewName()); // 원래 가려고 한 주소값이 담겨있다
                modelAndView.setViewName("/user/needLogin");
                // 담겨있는 주소값이 만약 로그인이 필요하다면 주소값을 가로채서 다른 주소값으로 보내버리는 방식
            }
        }
    // view의 처리가 끝난 후 처리하는 구간
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
