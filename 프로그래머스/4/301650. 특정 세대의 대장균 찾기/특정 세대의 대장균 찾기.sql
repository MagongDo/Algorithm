WITH RECURSIVE Generation AS (
    -- 1. 1세대: PARENT_ID가 NULL인 경우
    SELECT 
        ID, 
        PARENT_ID, 
        1 AS GEN
    FROM 
        ECOLI_DATA
    WHERE 
        PARENT_ID IS NULL

    UNION ALL

    -- 2. 재귀적으로 부모에서 자식으로 내려감
    SELECT 
        e.ID, 
        e.PARENT_ID, 
        g.GEN + 1 AS GEN
    FROM 
        ECOLI_DATA e
    INNER JOIN 
        Generation g
    ON 
        e.PARENT_ID = g.ID
)

-- 3. 3세대만 추출
SELECT 
    ID
FROM 
    Generation
WHERE 
    GEN = 3
ORDER BY 
    ID;
