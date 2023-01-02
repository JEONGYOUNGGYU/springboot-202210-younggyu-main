package com.study.springboot202210younggyu.web.controller.account;


import com.study.springboot202210younggyu.aop.annotation.ParamsAspect;
import com.study.springboot202210younggyu.aop.annotation.PrintTestAspect;
import com.study.springboot202210younggyu.aop.annotation.TimerAspect;
import com.study.springboot202210younggyu.aop.annotation.ValidAspect;
import com.study.springboot202210younggyu.service.UserService;
import com.study.springboot202210younggyu.web.dto.CMRespDto;
import com.study.springboot202210younggyu.web.dto.UserDto;
import com.study.springboot202210younggyu.web.dto.UsernameDto;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
@Slf4j
@RestController
//@Validated
@RequestMapping("/api/account")
public class AccountApiController {

//     Simple Log Fasade
//    private static final Logger LOG = LoggerFactory.getLogger(AccountApiController.class);    << 얘 한줄을 @Slf4j로 대체


    @Autowired
    private UserService userService;

    @ParamsAspect
    @TimerAspect
    @ValidAspect    // 이게 달려있는 애들은 앞으로 전부 다 유효성 검사를 한다.
    @GetMapping("/username")
    public ResponseEntity<?> duplicateUsername(@Valid UsernameDto usernameDto, BindingResult bindingResult){            //에러수집 : bindingResult
        log.info("로그 출력!! 데이터: {}", usernameDto);
        userService.duplicateUsername(usernameDto.getUsername());

        return ResponseEntity.ok().body(new CMRespDto<>("가입가능한 사용자이름", true));
    }


    @ParamsAspect
    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody @Valid UserDto userDto, BindingResult bindingResult){
//        System.out.println(userDto);
//        System.out.println(bindingResult.getFieldErrors());

        return ResponseEntity
                .created(URI.create("/account/login"))
                .body(new CMRespDto<>("회원가입 완료", null));
    }
}
