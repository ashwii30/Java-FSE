package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.model.Employee;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    Iterable<Employee> getAllEmployees();
    Employee updateEmployee(long id, Employee employee);
    void deleteEmployee(long id);
}
