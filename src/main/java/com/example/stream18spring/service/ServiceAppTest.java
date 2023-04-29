package com.example.stream18spring.service;

public class ServiceAppTest {

    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();
        service.add("foo", "bar");
        service.add("foo2", "bar2");
        service.add("foo3", "bar3");
        service.delete("foo123123", "bar");


    }
}
