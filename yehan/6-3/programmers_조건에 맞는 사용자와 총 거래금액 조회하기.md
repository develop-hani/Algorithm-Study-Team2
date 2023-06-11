# [프로그래머스 164668번 조건에 맞는 사용자와 청 거래금액 조회하기](https://school.programmers.co.kr/learn/courses/30/lessons/164668)

### 🤔 문제 이해하기

1. 완료된 중고거래 총금액이 70만원 이상
2. 회원의 ID, NICKNAME, 거래 총금액 조회

### 💻 문제를 해결한 코드

```sql
SELECT u.USER_ID, u.NICKNAME, SUM(b.PRICE) 'TOTAL_SALES'
FROM USED_GOODS_BOARD b
    JOIN USED_GOODS_USER u
    ON b.WRITER_ID = u.USER_ID
WHERE STATUS = 'DONE'
GROUP BY b.WRITER_ID
HAVING SUM(b.PRICE) >= 700000
ORDER BY TOTAL_SALES;
```
