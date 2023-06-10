package com.example.stream18spring.experimental;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(1)
public class MyImpl3 implements MyInterface {
    @Override
    public void call() {
        System.out.println("baz");
    }
}
