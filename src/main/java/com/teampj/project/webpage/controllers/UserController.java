package com.teampj.project.webpage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teampj.project.webpage.entities.UserEntity;
import com.teampj.project.webpage.models.UserModel;
import com.teampj.project.webpage.services.UserService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public @ResponseBody void test() {
        List<UserEntity>  users = userService.selectUsers();

        log.info(users.toString());
    }
    
    
}
