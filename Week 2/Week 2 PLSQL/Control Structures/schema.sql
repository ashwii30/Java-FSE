CREATE TABLE customers (
    id NUMBER PRIMARY KEY,
    age NUMBER,
    loan_rate NUMBER
);

CREATE TABLE loans (
    customer_id NUMBER,
    interest_rate NUMBER,
    due_date DATE,
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);