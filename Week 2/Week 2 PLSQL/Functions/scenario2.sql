
    CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(p_amount NUMBER, p_rate NUMBER, p_years NUMBER) RETURN NUMBER IS
    BEGIN
        RETURN p_amount * (p_rate / 1200) / (1 - POWER(1 + p_rate / 1200, -p_years * 12));
    END CalculateMonthlyInstallment;
    /
    