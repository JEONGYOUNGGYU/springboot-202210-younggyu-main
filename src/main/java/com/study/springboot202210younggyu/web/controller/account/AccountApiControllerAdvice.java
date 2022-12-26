package com.study.springboot202210younggyu.web.controller.account;



import com.study.springboot202210younggyu.web.dto.CMRespDto;
import com.study.springboot202210younggyu.web.exception.CustomDuplicateUsernameException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AccountApiControllerAdvice {

    @ExceptionHandler(CustomDuplicateUsernameException.class)   //예외 생성된걸 ↓e 에 넣어줌
    public ResponseEntity<?> duplicateError(CustomDuplicateUsernameException e){
        return ResponseEntity.badRequest().body(new CMRespDto<>(e.getMessage(), e.getErrorMap()));
    }                                                         // key값             value 값

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> validationError(ConstraintViolationException e){
        Map<String, String> errorMap = new HashMap<>();
        System.out.println(e.getConstraintViolations());

        e.getConstraintViolations().forEach(error ->{
            String errorProperty = error.getPropertyPath().toString();
            errorProperty = errorProperty.substring(errorProperty.lastIndexOf(".") + 1);
            errorMap.put(errorProperty, error.getMessage());
        });
        return ResponseEntity.badRequest().body(new CMRespDto<>(e.getMessage(), errorMap));
    }

}
