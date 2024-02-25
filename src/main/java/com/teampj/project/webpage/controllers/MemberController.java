package com.teampj.project.webpage.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teampj.project.webpage.entities.MemberEntity;
import com.teampj.project.webpage.models.MemberModel;
import com.teampj.project.webpage.models.ResponseModel;
import com.teampj.project.webpage.services.MemberService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;



@Slf4j
@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/members")
    public String test() {
        return "members";
    }

    @GetMapping("/members/list")
    public @ResponseBody ResponseModel memberList() {
        List<MemberEntity> membersEntity = memberService.selectUsers();

        List<MemberModel> members = membersEntity.stream().map(MemberModel::new).collect(Collectors.toList());

        log.info(members.toString());
        return new ResponseModel<>(true, "정상적으로 조회되었습니다", null, members);
    }
    
    
    
}
