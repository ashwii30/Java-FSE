package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class BatchProcessingService {


    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void batchInsertEmployees(List<Employee> employees) {
        int batchSize = 50; // Set your batch size here

        for (int i = 0; i < employees.size(); i++) {
            entityManager.persist(employees.get(i));

            // Flush and clear the persistence context every batchSize
            if (i % batchSize == 0 && i > 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
        // Ensure all remaining entities are flushed
        entityManager.flush();
        entityManager.clear();
    }
}
