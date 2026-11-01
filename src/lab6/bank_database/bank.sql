CREATE DATABASE bank;
USE bank;

CREATE TABLE branch (
    branchName  VARCHAR(30) PRIMARY KEY,
    branchCity  VARCHAR(30),
    assets      DECIMAL(12,2)
);

CREATE TABLE customer (
    customerName   VARCHAR(30) PRIMARY KEY,
    customerStreet VARCHAR(30),
    customerCity   VARCHAR(30)
);

CREATE TABLE loan (
    branchName  VARCHAR(30),
    loanNumber  VARCHAR(10) PRIMARY KEY,
    amount      DECIMAL(10,2),
    FOREIGN KEY (branchName) REFERENCES Branch(branchName)
);

CREATE TABLE borrower (
    customerName VARCHAR(30),
    loanNumber   VARCHAR(10),
    PRIMARY KEY (customerName, loanNumber),
    FOREIGN KEY (loanNumber) REFERENCES Loan(loanNumber)
);

CREATE TABLE account (
    branchName    VARCHAR(30),
    accountNumber VARCHAR(10) PRIMARY KEY,
    balance       DECIMAL(10,2),
    FOREIGN KEY (branchName) REFERENCES Branch(branchName)
);

CREATE TABLE depositor (
    customerName  VARCHAR(30),
    accountNumber VARCHAR(10),
    PRIMARY KEY (customerName, accountNumber),
    FOREIGN KEY (accountNumber) REFERENCES Account(accountNumber)
);

DESC branch;
DESC customer;
DESC loan;
DESC borrower;
DESC account;
DESC depositor;

INSERT INTO branch VALUES
('Downtown',  'Brooklyn',   9000000),
('Redwood',   'Palo Alto',  2100000),
('Perryridge','Horseneck',  1700000),
('Mianus',    'Horseneck',   400000),
('Round Hill','Horseneck',  8000000),
('Pownal',    'Bennington',  300000),
('North Town','Rye',        3700000),
('Brighton',  'Brooklyn',   7100000);

INSERT INTO customer VALUES
('Jones',    'Main',       'Harrison'),
('Smith',    'North',      'Rye'),
('Hayes',    'Main',       'Harrison'),
('Curry',    'North',      'Rye'),
('Lindsay',  'Park',       'Pittsfield'),
('Turner',   'Putnam',     'Stamford'),
('Williams', 'Nassau',     'Princeton'),
('Adams',    'Spring',     'Pittsfield'),
('Johnson',  'Alma',       'Palo Alto'),
('Glenn',    'Stand Hill', 'Woodside'),
('Brooks',   'Senator',    'Brooklyn'),
('Green',    'Walnut',     'Stamford');

INSERT INTO loan VALUES
('Downtown',  'L-17', 1000),
('Redwood',   'L-23', 2000),
('Perryridge','L-15', 1500),
('Downtown',  'L-14', 1500),
('Mianus',    'L-93',  500),
('Round Hill','L-11',  900),
('Perryridge','L-16', 1300);

INSERT INTO borrower VALUES
('Jones',    'L-17'),
('Smith',    'L-23'),
('Hayes',    'L-15'),
('Jackson',  'L-14'),
('Curry',    'L-93'),
('Smith',    'L-11'),
('Williams', 'L-17'),
('Adams',    'L-16');

INSERT INTO account VALUES
('Downtown',  'A-101', 500),
('Mianus',    'A-215', 700),
('Perryridge','A-102', 400),
('Round Hill','A-305', 350),
('Brighton',  'A-201', 900),
('Redwood',   'A-222', 700),
('Brighton',  'A-217', 750);

INSERT INTO depositor VALUES
('Johnson', 'A-101'),
('Smith',   'A-215'),
('Hayes',   'A-102'),
('Turner',  'A-305'),
('Johnson', 'A-201'),
('Jones',   'A-217'),
('Lindsey', 'A-222');

SELECT * FROM branch;
SELECT * FROM customer;
SELECT * FROM loan;
SELECT * FROM borrower;
SELECT * FROM account;
SELECT * FROM depositor;

SELECT DISTINCT branchName FROM loan;

SELECT loanNumber FROM loan WHERE branchName = 'Perryridge' AND amount > 1200;

SELECT loanNumber FROM loan WHERE branchName = 'Perryridge' AND amount > 90000 AND amount < 100000;

SELECT customerName, borrower.loanNumber FROM borrower, loan WHERE borrower.loanNumber = loan.loanNumber;

SELECT customerName, loan.loanNumber FROM loan, borrower WHERE loan.branchname = 'Perryridge' AND loan.loanNumber = borrower.loanNumber;

select branchName from branch where assets > (SELECT MIN(assets) from branch where branchCity = 'Brooklyn');
