
CREATE TABLE customers (
    id NUMBER PRIMARY KEY,
    dob DATE
);

CREATE TABLE loans (
    loan_id NUMBER PRIMARY KEY,
    loan_amount NUMBER,
    interest_rate NUMBER,
    start_date DATE,
    end_date DATE
);

CREATE TABLE accounts (
    account_id NUMBER PRIMARY KEY,
    balance NUMBER
);
