package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(name = "Employee.findByDepartmentName")
    Page<Employee> findByDepartmentName(@Param("departmentName") String departmentName, Pageable pageable);

    @Query(name = "Employee.findByEmail")
    Employee findByEmail(@Param("email") String email);

    @Query(name = "Employee.findByName")
    Page<Employee> findByName(@Param("name") String name, Pageable pageable);
}
