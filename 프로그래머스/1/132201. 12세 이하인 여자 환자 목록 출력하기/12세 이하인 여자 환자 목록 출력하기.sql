-- 코드를 입력하세요
SELECT PT_NAME, PT_NO, GEND_CD, AGE, IFNULL(TLNO,'NONE') FROM PATIENT
WHERE GEND_CD = 'W' AND AGE<13
ORDER BY AGE DESC, PT_NAME ASC