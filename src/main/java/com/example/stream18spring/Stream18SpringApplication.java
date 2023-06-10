package com.example.stream18spring;

import com.example.stream18spring.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Stream18SpringApplication {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(Stream18SpringApplication.class, args);
        ctx.getBean(EmployeeService.class);
    }

}
