package com.study.springboot202210younggyu.IocAndDi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public Test1 t1() {
        return new Test1();
    }

    @Bean
    public Test2 t2() {
        return new Test2();
    }
}
