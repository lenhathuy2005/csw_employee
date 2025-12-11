package com.example.cswemployee.service;

import com.example.cswemployee.model.Employee;
import com.example.cswemployee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    // 1. getEmployees: retrieve all employees in an array
    public List<Employee> getEmployees() {
        return repo.findAll();
    }

    // 2. addEmployees(Employee e): add a new employee record
    public Employee addEmployee(Employee e) {
        if (repo.existsById(e.getId())) {
            throw new RuntimeException("Employee ID already exists!");
        }
        return repo.save(e);
    }

    // 3. updateEmployee(Employee e): modify an existing employee record
    public Employee updateEmployee(Employee e) {
        if (!repo.existsById(e.getId())) {
            throw new RuntimeException("Employee not found!");
        }
        return repo.save(e);
    }
}
