package com.iflytek;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(basePackages = "com.iflytek.dao")
public class Springweb1Application {

    public static void main(String[] args) {
        SpringApplication.run(Springweb1Application.class, args);
    }

}
