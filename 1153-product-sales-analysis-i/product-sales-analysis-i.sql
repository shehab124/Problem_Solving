# Write your MySQL query statement below
SELECT Product.product_name, Sales.year, Sales.price
FROM Sales
JOIN Product
ON Product.Product_id = Sales.Product_id;