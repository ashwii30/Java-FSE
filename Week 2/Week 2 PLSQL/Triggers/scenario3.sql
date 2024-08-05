
    CREATE OR REPLACE TRIGGER CheckTransactionRules
    BEFORE INSERT ON Transactions
    FOR EACH ROW
    BEGIN
        IF :NEW.TransactionType = 'Withdrawal' AND 
           (SELECT balance FROM accounts WHERE account_id = :NEW.AccountID) < :NEW.Amount THEN
            RAISE_APPLICATION_ERROR(-20004, 'Insufficient balance for withdrawal.');
        ELSIF :NEW.TransactionType = 'Deposit' AND :NEW.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20005, 'Deposit amount must be positive.');
        END IF;
    END CheckTransactionRules;
    /
    