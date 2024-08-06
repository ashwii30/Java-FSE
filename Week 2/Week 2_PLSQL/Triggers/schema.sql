
CREATE TABLE customers (
    id NUMBER PRIMARY KEY,
    last_modified DATE
);

CREATE TABLE transactions (
    transaction_id NUMBER PRIMARY KEY,
    account_id NUMBER,
    transaction_date DATE,
    amount NUMBER,
    transaction_type VARCHAR2(10)
);

CREATE TABLE audit_log (
    transaction_id NUMBER,
    account_id NUMBER,
    transaction_date DATE,
    amount NUMBER,
    transaction_type VARCHAR2(10)
);
