package com.study.springboot202210younggyu.web.exception;

import lombok.Getter;

import java.util.Map;

public class CustomDuplicateUsernameException extends RuntimeException {

    @Getter     // 얘가 있어야지 json에서 가져다 쓸 수 있다.
    private Map<String, String> errorMap;

    public CustomDuplicateUsernameException(String message, Map<String, String> errorMap) {
        super(message);
        this.errorMap = errorMap;
    }
}
