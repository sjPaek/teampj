package com.teampj.project.webpage.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.teampj.project.webpage.models.MemberModel;
import com.teampj.project.webpage.models.ResponseModel;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Slf4j
@Controller
public class MyInfoController {
    
    @GetMapping("/myinfo")
    public String myinfo(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.getAttribute("logged");
        model.addAttribute("member", (MemberModel)session.getAttribute("logged"));
        return "myinfo";
    }

    @PostMapping("/myinfo/save")
    public @ResponseBody ResponseModel<MemberModel> myinfoSave(MemberModel model) {
        log.info(model.toString());
        return null;
    }
    
    
}
