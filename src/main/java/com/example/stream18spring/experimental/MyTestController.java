package com.example.stream18spring.experimental;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyTestController {

    private final List<MyInterface> impls;

    public MyTestController(List<MyInterface> impls) {
        this.impls = impls;
        impls.forEach(MyInterface::call);
    }
}
