package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.projection.EmployeeProjection;
import com.example.EmployeeManagementSystem.projection.EmployeeSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e.id AS id, e.name AS name, e.salary AS salary FROM Employee e")
    List<EmployeeProjection> findAllEmployeeProjections();

    @Query("SELECT new com.example.EmployeeManagementSystem.projection.EmployeeSummary(e.id, e.name, e.salary) FROM Employee e")
    List<EmployeeSummary> findAllEmployeeSummaries();
}
