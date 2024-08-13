package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    Page<Employee> getAllEmployees(Pageable pageable);
    Employee updateEmployee(long id, Employee employee);
    void deleteEmployee(long id);
    Page<Employee> getEmployeesByDepartmentName(String departmentName, Pageable pageable);
    Page<Employee> getEmployeesByName(String name, Pageable pageable);
}
