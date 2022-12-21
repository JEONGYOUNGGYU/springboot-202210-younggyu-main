package com.study.springboot202210younggyu.web.controller;

import com.study.springboot202210younggyu.service.UserService;
import com.study.springboot202210younggyu.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController // controller랑 restcontroller의 차이점 일반controller은 html파일을 응답할때,  responsebody를 달아주면 html를 응답하는것이 아니고 데이터응답으로...
                // restcontroller 데이터응답만 할 때..
                // requestmapping
@RequestMapping("/api/db/test")
public class DBTestController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto){ //requestbody는 userdto라는 객체를 받을건데 json형태로 받는것을 말한다, 제네릭와일드카드? <?> 왜 쓰냐 "응답할 데이터" < String ,
        System.out.println(userDto);
        userService.addUser(userDto);
        int userId = userService.addUser(userDto);
//        return new ResponseEntity<>("응답할 데이터", HttpStatus.CREATED);
        return ResponseEntity.created(URI.create("/api/db/test/user/" + userId)).body(userDto);
    }               //↑↑쓰는이유 rest api는 상태코드까지 마음껏 바꿔 줄 수 있어야한다
    @GetMapping("/user/{userId}")
                        //
    public ResponseEntity<?> getUser(@PathVariable int userId) {
        UserDto userDto = userService.getUser(userId);
        return ResponseEntity.ok().body(userDto);
    }                        // ok는 200번
}
