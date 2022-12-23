package com.study.springboot202210younggyu.web.dto.controller.account;



import com.study.springboot202210younggyu.web.dto.CMRespDto;
import com.study.springboot202210younggyu.web.exception.CustomDuplicateUsernameException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AccountApiControllerAdvice {

    @ExceptionHandler(CustomDuplicateUsernameException.class)   //예외 생성된걸 ↓e 에 넣어줌
    public ResponseEntity<?> duplicateError(CustomDuplicateUsernameException e){
        return ResponseEntity.badRequest().body(new CMRespDto<>(e.getMessage(), e.getErrorMap()));
    }                                                         // key값             value 값



}
