
    CREATE OR REPLACE PROCEDURE TransferFunds(p_from_account NUMBER, p_to_account NUMBER, p_amount NUMBER) IS
    BEGIN
        IF (SELECT balance FROM accounts WHERE account_id = p_from_account) < p_amount THEN
            RAISE_APPLICATION_ERROR(-20003, 'Insufficient funds.');
        END IF;
        
        UPDATE accounts
        SET balance = balance - p_amount
        WHERE account_id = p_from_account;
        
        UPDATE accounts
        SET balance = balance + p_amount
        WHERE account_id = p_to_account;
        
        COMMIT;
    END TransferFunds;
    /
    