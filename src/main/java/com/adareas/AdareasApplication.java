package com.adareas;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.adareas.mapper")
@SpringBootApplication
public class AdareasApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdareasApplication.class, args);
    }

}
