
    DECLARE
      CURSOR GenerateMonthlyStatements IS
        SELECT account_id, transaction_date, amount FROM transactions
        WHERE EXTRACT(MONTH FROM transaction_date) = EXTRACT(MONTH FROM SYSDATE);
      v_transaction GenerateMonthlyStatements%ROWTYPE;
    BEGIN
      OPEN GenerateMonthlyStatements;
      LOOP
        FETCH GenerateMonthlyStatements INTO v_transaction;
        EXIT WHEN GenerateMonthlyStatements%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Account ID: ' || v_transaction.account_id ||
                             ', Date: ' || v_transaction.transaction_date ||
                             ', Amount: ' || v_transaction.amount);
      END LOOP;
      CLOSE GenerateMonthlyStatements;
    END;
    /
    