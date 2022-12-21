package com.study.springboot202210younggyu.web.dto.controller;

import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controller1 {

//    @RequestMapping(value = "/page1", method = RequestMethod.GET)
    @GetMapping("/page1")
    public ModelAndView page1() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("page1");
        mav.addObject("key", "value");
        return mav;
    }

    @GetMapping("/page2")
    public String page2() {
        return "page2"; // 그냥 string을 리턴하는 걸로 가도 viewresolver로 찾아줘서 page2가 띄워짐
                        // @ResponseBody를 위에 적어주면 데이터로 찾아준다
    }

}
