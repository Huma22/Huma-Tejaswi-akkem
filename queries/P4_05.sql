-- 5.	Write a SQL query which which produces a table containing the 
-- name of each country and the count of how many articles are in the dataset from each country.

SELECT country, COUNT(news_id) AS articleCount
FROM country_table
LEFT JOIN news
USING (country_id)
GROUP BY country
ORDER BY articleCount DESC;
