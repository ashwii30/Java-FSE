
    CREATE OR REPLACE PACKAGE EmployeeManagement AS
      PROCEDURE HireNewEmployee(p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_department VARCHAR2, p_hire_date DATE);
      PROCEDURE UpdateEmployeeDetails(p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_department VARCHAR2);
      FUNCTION CalculateAnnualSalary(p_id NUMBER) RETURN NUMBER;
    END EmployeeManagement;
    /

    CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
      PROCEDURE HireNewEmployee(p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_department VARCHAR2, p_hire_date DATE) IS
      BEGIN
          INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
          VALUES (p_id, p_name, p_position, p_salary, p_department, p_hire_date);
          COMMIT;
      END HireNewEmployee;

      PROCEDURE UpdateEmployeeDetails(p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_department VARCHAR2) IS
      BEGIN
          UPDATE Employees
          SET Name = p_name, Position = p_position, Salary = p_salary, Department = p_department
          WHERE EmployeeID = p_id;
          COMMIT;
      END UpdateEmployeeDetails;

      FUNCTION CalculateAnnualSalary(p_id NUMBER) RETURN NUMBER IS
      v_salary NUMBER;
      BEGIN
          SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_id;
          RETURN v_salary * 12;
      EXCEPTION
          WHEN NO_DATA_FOUND THEN
              RETURN 0;
      END CalculateAnnualSalary;
    END EmployeeManagement;
    /
    