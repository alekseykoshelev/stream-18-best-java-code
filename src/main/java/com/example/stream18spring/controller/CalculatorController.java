package com.example.stream18spring.controller;

import com.example.stream18spring.service.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        return doWithCheck(num1, num2, "+");
    }

    @GetMapping("/minus")
    public String minus(@RequestParam int num1, @RequestParam int num2) {
        return doWithCheck(num1, num2, "-");
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam int num1, @RequestParam int num2) {
        return doWithCheck(num1, num2, "*");
    }

    @GetMapping("/divide")
    public ResponseEntity<String> divide(@RequestParam int num1, @RequestParam int num2) {
        if (num2 == 0) {
            return ResponseEntity.badRequest().body("На 0 не делим!");
        }
        return ResponseEntity.ok(doWithCheck(num1, num2, "/"));
    }

    private String doWithCheck(Integer num1, Integer num2, String op) {
        if (num1 == null || num2 == null) {
            return "Please enter a number";
        }
        switch (op) {
            case "+":
                return num1 + " " + op + " " + num2 + " = " + calculatorService.plus(num1, num2);
            case "-":
                return num1 + " " + op + " " + num2 + " = " + calculatorService.minus(num1, num2);
            case "/":
                return num1 + " " + op + " " + num2 + " = " + calculatorService.divide(num1, num2);
            case "*":
                return num1 + " " + op + " " + num2 + " = " + calculatorService.multiply(num1, num2);
            default:
                return "Неизвестная операция!";
        }
    }
}
