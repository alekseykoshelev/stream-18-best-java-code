package com.example.stream18spring.experimental;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(3)
public class MyImpl2 implements MyInterface {
    @Override
    public void call() {
        System.out.println("bar");
    }
}
