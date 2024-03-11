package com.teampj.project.webpage.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.teampj.project.webpage.models.MemberModel;
import com.teampj.project.webpage.models.ResponseModel;
import com.teampj.project.webpage.services.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;




@Slf4j
@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public @ResponseBody ResponseModel<MemberModel> login(MemberModel model, HttpServletRequest  request) {        
        return loginService.doLogin(model, request);
    }

    @GetMapping("/logout")
    public String getMethodName(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("logged", null);
        return "index";
    }
    
    
    
    
}
