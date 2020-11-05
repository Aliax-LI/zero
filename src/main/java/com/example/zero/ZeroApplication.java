package com.example.zero;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@MapperScan("com.example.zero.mapper")
public class ZeroApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZeroApplication.class, args);
    }

}
