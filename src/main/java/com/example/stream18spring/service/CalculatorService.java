package com.example.stream18spring.service;


import org.springframework.stereotype.Component;

@Component
public class CalculatorService {

    public int plus(int num1, int num2) {
        return num1 + num2;
    }

    public int divide(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException();
        }
        return num1 / num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public int minus(int num1, int num2) {
        return num1 - num2;
    }
}
