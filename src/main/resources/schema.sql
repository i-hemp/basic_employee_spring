CREATE TABLE IF NOT EXISTS Employee (
    employeeId SERIAL PRIMARY KEY,
    employeeName VARCHAR(100) NOT NULL,
    employeeAddress VARCHAR(255) NOT NULL,
    employeeSalary DECIMAL(10,2) NOT NULL
);
