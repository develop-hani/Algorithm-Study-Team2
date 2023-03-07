문제 회고를 위해 알고리즘 풀이 기록을 남깁니다.

# 백준 문제번호 문제제목
[1107 리모컨](https://www.acmicpc.net/problem/1107)

### 문제 이해하기
리모컨에는 숫자가 0~9까지 있고, +, -버튼이 있다.
채널 N이 주어질 때 리모컨을 최소한으로 클릭해서 N으로 갈 수 있는
최소 클릭 횟수를 구하는 문제이다.
단, 리모컨에는 고장난 버튼이 존재한다.


### 문제 접근 방법
중복순열을 활용한 완전탐색으로 접근하였다.
고장나지 않은 리모콘의 숫자 중에서 채널N의 길이만큼 선택하는 중복순열을 구하고
중복순열을 이어붙인 숫자와 채널N의 차이를 통해 +, - 버튼을 클릭하는 횟수도
고려하여 최소값을 갱신하였다.


### 구현 배경 지식
1. 중복순열
2. 완전탐색


### 접근 방법을 적용한 코드
```python
def dfs(depth, case):
    print(case)
    global answer
    if len(case) != 0:
        answer = min(answer, abs(int(case) - N) + depth)

    if depth == target:
        return

    for i in buttons:
        dfs(depth + 1, case + str(i))


N = int(input())
M = int(input())

buttons = set(i for i in range(10))
if M != 0:
    brokens = list(map(int, input().split()))
    buttons -= set(brokens)

start = 100
target = len(str(N)) + 1

answer = abs(start - N)
dfs(0, "")
print(answer)
```

