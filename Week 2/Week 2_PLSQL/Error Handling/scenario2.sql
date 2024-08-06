
    CREATE OR REPLACE PROCEDURE UpdateSalary(p_id NUMBER, p_percentage NUMBER) IS
    BEGIN
        UPDATE employees
        SET salary = salary * (1 + p_percentage / 100)
        WHERE employee_id = p_id;
        IF SQL%ROWCOUNT = 0 THEN
            RAISE_APPLICATION_ERROR(-20002, 'Employee ID does not exist.');
        END IF;
        COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END UpdateSalary;
    /
    