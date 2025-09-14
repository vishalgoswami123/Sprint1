USE employeedb;
DROP TABLE IF EXISTS employees;
CREATE TABLE employees (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    salary DECIMAL(10,2)
);
INSERT INTO employees (first_name, last_name, name, email, salary) VALUES
('Vishal', 'MULL', 'Vishal', 'vishal@example.com', 50000.00),
('Amit', 'ALL', 'Amit Kumar', 'amit@example.com', 40000.00),
('Neha', 'HULL', 'Neha Sharma', 'neha@example.com', 45000.00),
('Priya', 'SHARMA', 'Priya Sharma', 'priya@example.com', 45000.00),
('Rahul', 'VERMA', 'Rahul Verma', 'rahul@example.com', 48000.00),
('Sneha', 'PATEL', 'Sneha Patel', 'sneha@example.com', 47000.00),
('Ankit', 'SINGH', 'Ankit Singh', 'ankit@example.com', 42000.00),
('Riya', 'MEHTA', 'Riya Mehta', 'riya@example.com', 46000.00),
('Karan', 'JOSHI', 'Karan Joshi', 'karan@example.com', 43000.00),
('Saurabh', 'GUPTA', 'Saurabh Gupta', 'saurabh@example.com', 41000.00);
SELECT * FROM employees;
