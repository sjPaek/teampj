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
        
        HttpSession session = request.getSession();

        MemberModel member = loginService.getMemberByUserId(model);

        if(model.getUserPassword().equals(member.getUserPassword())){            
            if(session == null || session.getAttribute("logged") == null){
                session.setAttribute("logged", member);
            }

            return new ResponseModel<>(true, "정상적으로 로그인 되었습니다", null, null);
        }else{            
            return new ResponseModel<>(false, "로그인이 실패했습니다. 다시 시도해주세요", null, null);
        }
    
    }

    @GetMapping("/logout")
    public String getMethodName(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("logged", null);
        return "index";
    }
    
    
    
    
}
