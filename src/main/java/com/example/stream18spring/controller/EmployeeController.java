package com.example.stream18spring.controller;

import com.example.stream18spring.model.Employee;
import com.example.stream18spring.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName) {
        return service.add(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return service.find(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName) {
        return service.delete(firstName, lastName);
    }

    @GetMapping("/all")
    public Collection<Employee> remove() {
        return service.getEmployees();
    }

    @ExceptionHandler({Exception.class})
    private void handle(Exception e) throws Exception {
        logger.error("Exception:", e);
        throw e;
    }
}
