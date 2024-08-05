
    CREATE OR REPLACE PROCEDURE SafeTransferFunds(p_from_account NUMBER, p_to_account NUMBER, p_amount NUMBER) IS
    BEGIN
        UPDATE accounts
        SET balance = balance - p_amount
        WHERE account_id = p_from_account;
        IF SQL%ROWCOUNT = 0 THEN
            RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds or invalid account.');
        END IF;
        
        UPDATE accounts
        SET balance = balance + p_amount
        WHERE account_id = p_to_account;
        
        COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
    END SafeTransferFunds;
    /
    