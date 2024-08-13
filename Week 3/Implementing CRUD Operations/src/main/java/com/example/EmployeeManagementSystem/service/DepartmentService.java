package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.model.Department;

public interface DepartmentService {
    Department saveDepartment(Department department);
    Iterable<Department> getAllDepartments();
    Department updateDepartment(long id, Department department);
    void deleteDepartment(long id);
}
