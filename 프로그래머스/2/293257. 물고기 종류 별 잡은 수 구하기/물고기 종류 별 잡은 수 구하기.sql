-- 코드를 작성해주세요
SELECT COUNT(*) AS FISH_COUNT, FN.FISH_NAME FROM FISH_INFO AS FI JOIN FISH_NAME_INFO AS FN ON 
    FI.FISH_TYPE = FN.FISH_TYPE
GROUP BY FN.FISH_NAME
ORDER BY FISH_COUNT DESC
