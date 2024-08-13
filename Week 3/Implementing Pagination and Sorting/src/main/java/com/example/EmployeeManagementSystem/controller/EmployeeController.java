package com.example.EmployeeManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public Page<Employee> getAllEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort[0]).ascending());
        if (sort.length > 1 && "desc".equalsIgnoreCase(sort[1])) {
            pageable = PageRequest.of(page, size, Sort.by(sort[0]).descending());
        }

        return employeeService.getAllEmployees(pageable);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getAllEmployees(PageRequest.of(0, Integer.MAX_VALUE))
                .getContent().stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst().orElse(null);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        return employeeService.updateEmployee(id, employeeDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/by-name")
    public Page<Employee> getEmployeesByName(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort[0]).ascending());
        if (sort.length > 1 && "desc".equalsIgnoreCase(sort[1])) {
            pageable = PageRequest.of(page, size, Sort.by(sort[0]).descending());
        }

        return employeeService.getEmployeesByName(name, pageable);
    }

    @GetMapping("/department/{name}")
    public Page<Employee> getEmployeesByDepartmentName(
            @PathVariable String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort[0]).ascending());
        if (sort.length > 1 && "desc".equalsIgnoreCase(sort[1])) {
            pageable = PageRequest.of(page, size, Sort.by(sort[0]).descending());
        }

        return employeeService.getEmployeesByDepartmentName(name, pageable);
    }

    @GetMapping("/email")
    public Employee getEmployeeByEmail(@RequestParam String email) {
        return employeeService.getAllEmployees(PageRequest.of(0, Integer.MAX_VALUE))
                .getContent().stream()
                .filter(emp -> emp.getEmail().equals(email))
                .findFirst().orElse(null);
    }
}
