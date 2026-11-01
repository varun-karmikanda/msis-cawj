mysql> SELECT DISTINCT branchName FROM loan;
+------------+
| branchName |
+------------+
| Downtown   |
| Mianus     |
| Perryridge |
| Redwood    |
| Round Hill |
+------------+
5 rows in set (0.00 sec)

mysql> SELECT loanNumber FROM loan WHERE branchName = 'Perryridge' AND amount > 1200;
+------------+
| loanNumber |
+------------+
| L-15       |
| L-16       |
+------------+
2 rows in set (0.00 sec)

mysql> SELECT loanNumber FROM loan WHERE branchName = 'Perryridge' AND amount > 90000 AND amount < 100000;
Empty set (0.00 sec)

mysql> SELECT customerName, borrower.loanNumber FROM borrower, loan WHERE borrower.loanNumber = loan.loanNumber;
+--------------+------------+
| customerName | loanNumber |
+--------------+------------+
| Jackson      | L-14       |
| Jones        | L-17       |
| Williams     | L-17       |
| Curry        | L-93       |
| Hayes        | L-15       |
| Adams        | L-16       |
| Smith        | L-23       |
| Smith        | L-11       |
+--------------+------------+
8 rows in set (0.00 sec)

mysql> SELECT customerName, loan.loanNumber FROM loan, borrower WHERE loan.branchname = 'Perryridge' AND loan.loanNumber = borrower.loanNumber;
+--------------+------------+
| customerName | loanNumber |
+--------------+------------+
| Hayes        | L-15       |
| Adams        | L-16       |
+--------------+------------+
2 rows in set (0.00 sec)

mysql> select branchName from branch where assets > (SELECT MIN(assets) from branch where branchCity = 'Brooklyn');
+------------+
| branchName |
+------------+
| Downtown   |
| Round Hill |
+------------+
2 rows in set (0.00 sec)

