-- 10.	Write a SQL query linking each author to their probable political bias, based on the articles they’ve written.  
-- The table should contain three columns, the author name, the political bias, and the count of how many articles that author has published with that bias.  
-- Order the results alphabetically by author name, from greatest number of articles to least, and alphabetically by bias in the case of a tie.

SELECT author, political_bias, COUNT(*) AS numArticles
FROM news
JOIN news_authors
USING (news_id)
JOIN author_table
USING (author_id)
JOIN political_bias_table
USING (political_bias_id)
GROUP BY author, political_bias
ORDER BY author, COUNT(*) DESC, political_bias;
