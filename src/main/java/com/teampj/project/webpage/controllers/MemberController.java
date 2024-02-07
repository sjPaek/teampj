package com.teampj.project.webpage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teampj.project.webpage.entities.MemberEntity;
import com.teampj.project.webpage.services.MemberService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/members")
    public @ResponseBody void test() {
        List<MemberEntity>  users = memberService.selectUsers();

        log.info(users.toString());
    }
    
    
}
