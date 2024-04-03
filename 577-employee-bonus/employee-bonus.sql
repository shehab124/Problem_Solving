# Write your MySQL query statement below
SELECT e.name, b.bonus
FROM Employee as e
LEFT JOIN BONUS as b
ON e.empId = b.empId
WHERE b.bonus < 1000 OR b.bonus IS NULL
;