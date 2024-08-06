
    DECLARE
      CURSOR c_customers IS
        SELECT id, age, loan_rate FROM customers;
      v_customer c_customers%ROWTYPE;
    BEGIN
      OPEN c_customers;
      LOOP
        FETCH c_customers INTO v_customer;
        EXIT WHEN c_customers%NOTFOUND;
        IF v_customer.age > 60 THEN
          UPDATE loans SET interest_rate = interest_rate - 0.01
          WHERE customer_id = v_customer.id;
        END IF;
      END LOOP;
      CLOSE c_customers;
      COMMIT;
    END;
    /
    