package com.study.springboot202210younggyu.aop;

import com.study.springboot202210younggyu.web.exception.CustomValidException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;

import java.util.HashMap;
import java.util.Map;


@Aspect
@Component
public class ValidationAop {

    @Pointcut("execution(* com.study.springboot202210younggyu.web.controller.account.AccountApiController.*(..))")
                    //   ↑ return 자료형
    private void executionPointCut(){}

    @Pointcut("@annotation(com.study.springboot202210younggyu.aop.annotation.ValidAspect)")
    private void annotationPointCut(){}

    //  ↓ 핵심은 @Around
    @Around("annotationPointCut()")              //  ↓ 매개변수의 정보들이 다 들어있다
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        Object[] args = proceedingJoinPoint.getArgs();  //getArgs()에 대한걸 다 가져와라
        for(Object arg : args){
            System.out.println(arg);
        }

        System.out.println("AOP 작동함!!");

        BeanPropertyBindingResult bindingResult = null;


        for(Object arg : args){
            if(arg.getClass() == BeanPropertyBindingResult.class){
                bindingResult = (BeanPropertyBindingResult) arg;
                break;
            }
        }

        if(bindingResult != null){
            if(bindingResult.hasErrors()){
                Map<String, String> errorMap = new HashMap<>();
                bindingResult.getFieldErrors().forEach(error -> {
                    errorMap.put(error.getField(), error.getDefaultMessage());
                });

                throw new CustomValidException(errorMap);
            }
        }
        // 메소드 호출 전 처리
        Object returnValue = proceedingJoinPoint.proceed();
        // 메소드 호출 후 처리

        return returnValue;
    }
}
