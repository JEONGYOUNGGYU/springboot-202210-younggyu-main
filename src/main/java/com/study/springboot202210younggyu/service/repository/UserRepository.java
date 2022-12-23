package com.study.springboot202210younggyu.service.repository;

import com.study.springboot202210younggyu.web.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {   //mapper를 적어주면 userrepository랑 user.xml 이랑 연동가능
    public int saveUser(UserDto userDto);       //int는 insert,update,delete에 대해 리턴  int = insert,update,delete

    public UserDto findUserByUserId(int userId);

    public UserDto findUserByUsername(String username);
}
