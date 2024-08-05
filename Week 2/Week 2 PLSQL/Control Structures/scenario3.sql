
    DECLARE
      CURSOR c_loans IS
        SELECT customer_id, loan_id, due_date FROM loans
        WHERE due_date BETWEEN SYSDATE AND SYSDATE + 30;
      v_loan c_loans%ROWTYPE;
    BEGIN
      OPEN c_loans;
      LOOP
        FETCH c_loans INTO v_loan;
        EXIT WHEN c_loans%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || v_loan.loan_id ||
                             ' for customer ID ' || v_loan.customer_id || 
                             ' is due on ' || v_loan.due_date);
      END LOOP;
      CLOSE c_loans;
    END;
    /
    