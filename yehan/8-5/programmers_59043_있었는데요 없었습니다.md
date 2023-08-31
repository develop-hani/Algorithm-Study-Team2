# programmers*59043*있었는데요 없었습니다

[programmers*59043*있었는데요 없었습니다](https://school.programmers.co.kr/learn/courses/30/lessons/59043)

### 🤔 문제 이해하기

1. 동물 보호 시작일이 적힌 테이블과 보호 종료일이 적힌 테이블이 있다.
2. 보호 종료일이 보호 시작일보다 앞서는 잘못된 동물의 아이디와 이름을 조회한다.

### ⭐ 풀이 방법

1. Join

### 💻 문제를 해결한 코드

```java
SELECT ai.ANIMAL_ID, ai.NAME
FROM ANIMAL_INS ai JOIN ANIMAL_OUTS ao ON ai.ANIMAL_ID = ao.ANIMAL_ID
WHERE ai.DATETIME > ao.DATETIME
ORDER BY ai.DATETIME;
```
