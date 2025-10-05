CREATE TABLE Employee (
    EmpID INT PRIMARY KEY,
    Name VARCHAR(50),
    Salary DECIMAL(10, 2)
);

INSERT INTO Employee (EmpID, Name, Salary) VALUES
(1, 'Alice', 55000.00),
(2, 'Bob', 62000.00),
(3, 'Charlie', 47000.00);
