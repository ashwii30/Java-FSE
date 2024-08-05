
    DECLARE
      CURSOR UpdateLoanInterestRates IS
        SELECT loan_id, interest_rate FROM loans;
      v_loan UpdateLoanInterestRates%ROWTYPE;
    BEGIN
      OPEN UpdateLoanInterestRates;
      LOOP
        FETCH UpdateLoanInterestRates INTO v_loan;
        EXIT WHEN UpdateLoanInterestRates%NOTFOUND;
        UPDATE loans
        SET interest_rate = interest_rate + 0.01
        WHERE loan_id = v_loan.loan_id;
      END LOOP;
      CLOSE UpdateLoanInterestRates;
      COMMIT;
    END;
    /
    