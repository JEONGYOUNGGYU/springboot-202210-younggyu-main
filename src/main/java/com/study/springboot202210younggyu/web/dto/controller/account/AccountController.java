package com.study.springboot202210younggyu.web.dto.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {


    @GetMapping("/account/register")
    public String loadRegister(){
        return "account/register";
    }

//    @GetMapping("/product/product_add")
//    public String productRegister() {
//        return "product/product_add";
//    }
}
