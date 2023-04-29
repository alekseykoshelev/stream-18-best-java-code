package com.example.stream18spring.exception;

import java.util.regex.Pattern;

public class Checker {

    private static final Pattern PATTERN = Pattern.compile("\\w+");

    public static void check(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        var mather = PATTERN.matcher(login);
        if (login.length() > 20 || !mather.matches()) {
            throw new WrongLoginException("Login must contain letters, numbers and underline");
        }
        var passwordMatcher = PATTERN.matcher(password);
        if (password.length() >= 20 || !password.equals(confirmPassword) || !passwordMatcher.matches()) {
            throw new WrongPasswordException();
        }
    }
}
