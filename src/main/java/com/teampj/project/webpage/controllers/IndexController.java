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

    @GetMapping("/shop")
    public String shop() {
        return "shop";
    }

    @GetMapping("/shop-detail")
    public String shopDetail() {
        return "shop-detail";
    }

    @GetMapping("/cart")
    public String cart() {
        return "cart";
    }

    @GetMapping("/chackout")
    public String chackout() {
        return "chackout";
    }

    @GetMapping("/testimonial")
    public String testimonial() {
        return "testimonial";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/error")
    public String error() {
        return "common/404";
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
