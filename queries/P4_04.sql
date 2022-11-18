-- 4.	Write a SQL query which produces a table of unique publisher names that have news articles in the data set.

SELECT publisher
FROM publisher_table
JOIN news
USING (publisher_id)
GROUP BY publisher
ORDER BY publisher;
