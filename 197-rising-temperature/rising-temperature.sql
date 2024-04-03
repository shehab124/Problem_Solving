# Write your MySQL query statement below
SELECT b.id as Id
FROM Weather as a
INNER JOIN Weather as b
ON DATEDIFF(b.recordDate, a.recordDate) = 1 
WHERE b.temperature > a.temperature;