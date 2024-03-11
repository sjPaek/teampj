package com.teampj.project.webpage.controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.teampj.project.webpage.entities.MemberEntity;
import com.teampj.project.webpage.models.MemberModel;
import com.teampj.project.webpage.models.ResponseModel;
import com.teampj.project.webpage.services.MemberService;
import com.teampj.project.webpage.services.MyInfoService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Slf4j
@Controller
public class MyInfoController {

    @Autowired
    MemberService memberService;
    
    @Autowired
    MyInfoService myInfoService;

    @GetMapping("/myinfo")
    public String myinfo(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.getAttribute("logged");        
        model.addAttribute("member", (MemberModel)session.getAttribute("logged"));
        return "myinfo";
    }

    @PostMapping("/myinfo/save")
    public @ResponseBody ResponseModel<MemberModel> myinfoSave(MemberModel model, HttpServletRequest request) {
        log.info(model.toString());
        return myInfoService.updateMyInfo(model, request);
    }
    
    
}
