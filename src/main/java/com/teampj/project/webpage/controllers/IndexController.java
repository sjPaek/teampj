package com.teampj.project.webpage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teampj.project.webpage.models.TestModel;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;




@Slf4j
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    
    @GetMapping("/test")
    public String testPage() {
        return "test";
    }

    @GetMapping("/mvc")
    public String mvc() {
        return "mvc";
    }


    @PostMapping("/save")
    public @ResponseBody void save(TestModel model) {
        log.info(model.toString());            
    }
    
    

    
}
