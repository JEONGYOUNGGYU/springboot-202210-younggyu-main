package com.study.springboot202210younggyu.service;

import com.fasterxml.jackson.core.JsonPointer;
import com.study.springboot202210younggyu.service.repository.UserRepository;
import com.study.springboot202210younggyu.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public int addUser(UserDto userDto){
        int userId = 0;
        System.out.println("데이터베이스에 insert 전 : " +userDto);
        userRepository.saveUser(userDto);
        System.out.println("데이터베이스에 insert 후 : " + userDto);

        return userDto.getUserId();
    }

    public UserDto getUser(int userId){
        UserDto userDto = null;
        userDto = userRepository.findUserByUserId(userId);

        return userDto;
    }
}