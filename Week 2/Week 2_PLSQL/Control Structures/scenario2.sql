
    DECLARE
      CURSOR c_customers IS
        SELECT id, balance FROM customers;
      v_customer c_customers%ROWTYPE;
    BEGIN
      OPEN c_customers;
      LOOP
        FETCH c_customers INTO v_customer;
        EXIT WHEN c_customers%NOTFOUND;
        IF v_customer.balance > 10000 THEN
          UPDATE customers SET IsVIP = TRUE WHERE id = v_customer.id;
        END IF;
      END LOOP;
      CLOSE c_customers;
      COMMIT;
    END;
    /
    