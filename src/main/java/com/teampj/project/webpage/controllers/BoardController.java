package com.teampj.project.webpage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BoardController {
    
    @GetMapping("board")
    public String board() {
        return "board/list";
    }

    @GetMapping("boardEdit")
    public String board_edit() {
        return "board/edit";
    }

    // @PostMapping("path")
    // public @ResponseBody ResponseModel save() {
        
        
    //     return new ResponseModel<>(true, "정상적으로 저장되었습니다", null);
    // }
    
    
    
}
