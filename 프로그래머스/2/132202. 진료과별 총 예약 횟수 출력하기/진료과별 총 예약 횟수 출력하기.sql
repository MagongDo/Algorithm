-- 코드를 입력하세요
SELECT MCDP_CD AS 진료과코드 , COUNT(*) AS 5월예약건수 FROM APPOINTMENT
WHERE DATE_FORMAT(APNT_YMD,'%Y-%m') LIKE '2022-05'
GROUP BY MCDP_CD
ORDER BY 5월예약건수 ASC, 진료과코드 ASC