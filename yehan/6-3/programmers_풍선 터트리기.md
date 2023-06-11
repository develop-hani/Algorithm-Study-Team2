문제 회고를 위해 알고리즘 풀이 기록을 남깁니다.

# [프로그래머스 68646번 풍선 터트리기](https://school.programmers.co.kr/learn/courses/30/lessons/68646)

### 🤔 문제 이해하기

1. 풍선이 하나 남을 때까지 조건에 맞추어 풍선을 터트린다.
   - 번호가 더 작은 풍선을 터트리는 행위는 최대 1번
   - 그 외에는 항상 번호가 더 큰 풍선을 터트린다.
2. 1,000,000,000 <= 주어진 번호 <= 1,000,000,000
   - int의 범위
3. 마지막까지 남을 수 있는 풍선의 수 구하기

### 📖 스토리 라인

1. 나의 왼쪽, 오른쪽에서 가장 작은 수 구하기
2. 양쪽에 나보다 작은 수가 있는 경우 풍선은 마지막까지 남길 수 없다.
3. (전체 풍선의 수 - 마지막까지 남을 수)를 구한다.

### 💻 문제를 해결한 코드

```java
class Solution {

    public int solution(int[] a) {
        int pop = 0; // 터질 수 있는 풍선의 수

        // 전처리
        int n = a.length;
        int[] left = new int[n];
        int[] right = new int[n];

        // 양쪽으로 가장 작은 수 구하기
        left[0] = a[0];
        right[n - 1] = a[n - 1];
        for (int i = 1; i < n; ++i) {
            left[i] = left[i-1] < a[i] ? left[i-1] : a[i];
            right[n-1-i] = right[n-i] < a[n-1-i] ? right[n-i] : a[n-1-i];
        }

        // 양쪽에 나보다 작은 수 있는지 보기
        for (int i = 0; i < n; ++i) {
            if(a[i] > left[i] && a[i] > right[i]) ++pop;
        }

        return n - pop;
    }
}
```
