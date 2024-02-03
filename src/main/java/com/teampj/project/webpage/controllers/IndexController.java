package com.teampj.project.webpage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



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
    

    
}
