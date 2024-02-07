package com.teampj.project.webpage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import lombok.extern.slf4j.Slf4j;


@Slf4j
public class InterceptorHandler implements HandlerInterceptor {

    @Override
     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        // Controller 실행 전에 수행되는 메소드.
        log.info("===== preHandler START =====");
        log.info("Request URL : {}", request.getRequestURI());

        HttpSession session = request.getSession(false);

        // MemberModel loginInfo = (MemberModel) session.getAttribute("logged");
        // log.info(loginInfo.toString());

        if( session == null || session.getAttribute("logged") == null){
            log.info("false");
            response.sendRedirect("/login");            
        }

        return true;
    }

      @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // Controller 실행 후 View가 랜더링 되기 전에 실행
        log.info("===== preHandler END =====");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // Controller 실행 후 View가 랜더링 된 후에 실행
        log.info("===== after Completion =====");
    }
    
}
