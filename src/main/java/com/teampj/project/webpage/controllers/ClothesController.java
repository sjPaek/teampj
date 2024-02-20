package com.teampj.project.webpage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ClothesController {

    @GetMapping("/best")
    public String clothesBest() {
        return "/clothes/best";
    }

    @GetMapping("/top")
    public String clothesTop() {
        return "/clothes/top";
    }

    @GetMapping("/outer")
    public String clothesOuter() {
        return "/clothes/outer";
    }

    @GetMapping("/knit")
    public String clothesKnit() {
        return "/clothes/knit";
    }

    @GetMapping("/pants")
    public String clothesPants() {
        return "/clothes/pants";
    }
    
    @GetMapping("/etc")
    public String clothesEtc() {
        return "/clothes/etc";
    }
    
}
