package com.example.shirotest;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.shirotest.mapper")
public class ShirotestApplication {


    public static void main(String[] args) {
        SpringApplication.run(ShirotestApplication.class, args);
    }


}
