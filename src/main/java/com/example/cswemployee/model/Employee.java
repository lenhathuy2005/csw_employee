package com.example.cswemployee.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees") // bảng "employees" trong MySQL
public class Employee {

    @Id
    private Long id;    // nhập tay, không auto-increment

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double salary;

    public Employee() {}

    public Employee(Long id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }
}
