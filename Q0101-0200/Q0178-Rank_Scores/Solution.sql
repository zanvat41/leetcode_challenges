# Write your MySQL query statement below
SELECT
  Score,
  (SELECT count(*) FROM (SELECT distinct Score s FROM Scores) tmp WHERE s >= Score) AS 'Rank'
FROM Scores
ORDER BY Score desc
