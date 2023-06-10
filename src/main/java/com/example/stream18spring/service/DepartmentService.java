package com.example.stream18spring.service;

import com.example.stream18spring.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee max(int dept) {
        return employeeService.getEmployees()
                .stream()
                .filter(e -> e.getDepartment() == dept)
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    public Optional<Employee> min(int dept) {
        return employeeService.getEmployees()
                .stream()
                .filter(e -> e.getDepartment() == dept)
                .min(Comparator.comparing(Employee::getSalary));
    }

    public Collection<Employee> allByDept(int dept) {
        return employeeService.getEmployees()
                .stream()
                .filter(e -> e.getDepartment() == dept)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> all() {
        Map<Integer, Employee> map = employeeService.getEmployees()
                .stream()
                .collect(Collectors.toMap(Employee::getDepartment, Function.identity(), (employee, employee2) -> {
                            if (employee.getSalary() > employee2.getSalary()) {
                                return employee;
                            }
                            return employee2;
                        },
                        HashMap::new
                ));


        return employeeService.getEmployees()
                .stream()
                .collect(groupingBy(Employee::getDepartment));
    }

//    public Employee maxSalary(int departmentId) {
//        return getEmployeeToDepartment(departmentId).stream()
//                .max(Comparator.comparingInt(e -> e.getSalary()))
//                .orElseThrow(() -> new EmployeeNotFoundException("Не найден сотрудник"));
//    }
//
//    public Employee minSalary(int departmentId) {
//        return getEmployeeToDepartment(departmentId)
//                .min(Comparator.comparingInt(Employee::getSalary))
//                .orElseThrow(() -> new EmployeeNotFoundException("Не найден сотрудник"));
//    }
//
//    public Stream<Employee> getEmployeeToDepartment(int departmentId) {
//        return employeeService.getEmployees().stream()
//                .filter(e -> e.getDepartment() == departmentId);
//    }

}
