
    DECLARE
      CURSOR ApplyAnnualFee IS
        SELECT account_id FROM accounts;
      v_account ApplyAnnualFee%ROWTYPE;
    BEGIN
      OPEN ApplyAnnualFee;
      LOOP
        FETCH ApplyAnnualFee INTO v_account;
        EXIT WHEN ApplyAnnualFee%NOTFOUND;
        UPDATE accounts
        SET balance = balance - 10
        WHERE account_id = v_account.account_id;
      END LOOP;
      CLOSE ApplyAnnualFee;
      COMMIT;
    END;
    /
    