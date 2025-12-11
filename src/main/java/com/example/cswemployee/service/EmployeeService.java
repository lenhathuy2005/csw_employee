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

    // Lấy tất cả nhân viên
    public List<Employee> getEmployees() {
        return repo.findAll();
    }

    // Thêm mới
    public Employee addEmployee(Employee e) {
        // nếu muốn chặn trùng ID thì mở comment dưới:
        // if (repo.existsById(e.getId())) {
        //     throw new RuntimeException("Employee ID already exists!");
        // }
        return repo.save(e);
    }

    // Cập nhật
    public Employee updateEmployee(Employee e) {
        if (!repo.existsById(e.getId())) {
            throw new RuntimeException("Không tìm thấy nhân viên ID = " + e.getId());
        }
        return repo.save(e);
    }

    // 🔥 XÓA
    public void deleteEmployee(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Không tìm thấy nhân viên ID = " + id);
        }
        repo.deleteById(id);
    }
}
