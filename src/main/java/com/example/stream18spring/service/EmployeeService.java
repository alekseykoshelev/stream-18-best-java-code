package com.example.stream18spring.service;

import com.example.stream18spring.exception.EmployeeAlreadyAddedException;
import com.example.stream18spring.exception.EmployeeNotFoundException;
import com.example.stream18spring.exception.EmployeeStorageIsFullException;
import com.example.stream18spring.exception.NotValidCharacterException;
import com.example.stream18spring.model.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class EmployeeService {

    private static final int MAX_SIZE = 100;

    private final Map<String, Employee> employees = new HashMap<>(MAX_SIZE);

    public Employee add(String firstName, String lastName) {
        checkArg(firstName, lastName);
        if (employees.size() > MAX_SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        var key = (firstName + "_" + lastName).toLowerCase();
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        var employee = create(firstName, lastName);
        employees.put(key, employee);
        return employee;
    }

    public Employee delete(String firstName, String lastName) {
        checkArg(firstName, lastName);
        var key = (firstName + "_" + lastName).toLowerCase();
        var removed = employees.remove(key);
        if (removed == null) {
            throw new EmployeeNotFoundException();
        }
        return removed;
    }

    public Employee find(String firstName, String lastName) {
        checkArg(firstName, lastName);
        var key = (firstName + "_" + lastName).toLowerCase();
        var employee = employees.get(key);
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public Collection<Employee> getEmployees() {
        return employees.values();
    }

    private void checkArg(String... args) {
        for (String arg : args) {
            if (!StringUtils.isAlpha(arg)) {
                throw new NotValidCharacterException();
            }
        }
    }

    private Employee create(String firstName, String lastName) {
        return new Employee(
                StringUtils.capitalize(firstName),
                StringUtils.capitalize(lastName),
                0, 0);
    }


    // experimental code
    private Key makeKey(String firstName, String lastName) {
        return new Key(
                StringUtils.capitalize(firstName),
                StringUtils.capitalize(lastName));
    }

    private static class Key {
        final String firstName;
        final String lastName;

        private Key(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return Objects.equals(firstName, key.firstName) && Objects.equals(lastName, key.lastName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName);
        }
    }
}
