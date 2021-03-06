package com.cat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.cat"})
@RestController
@MapperScan("com.cat.dao")
public class Start {


    public static void main(String[] args) {
        SpringApplication.run(Start.class, args);
    }
}
