package com.study.springboot202210younggyu.web.dto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller2 {

    @GetMapping("/controller/2")
    public String load(Model model) {
        model.addAttribute("name", "김준일");
        return "contorller_test";
    }
}
