package com.example.stream18spring.controller;

import com.example.stream18spring.exception.Checker;
import com.example.stream18spring.exception.WrongLoginException;
import com.example.stream18spring.exception.WrongPasswordException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;
import java.io.StringWriter;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam String login, @RequestParam String password) throws WrongLoginException, WrongPasswordException {
        Checker.check(login, password, password);
        return ResponseEntity.ok("LOGIN OK");
    }

    @ExceptionHandler({WrongPasswordException.class})
    public ResponseEntity<Object> handle(WrongPasswordException ex) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        return new ResponseEntity<>(sw.toString(), new HttpHeaders(), HttpStatus.UNAUTHORIZED);
    }
}
