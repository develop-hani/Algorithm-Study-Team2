# 구현1. combinations 사용
from itertools import combinations

N, M = map(int, input().split())

arr = [i for i in range(1, N + 1)]
cases = combinations(arr, M)
for case in cases:
    for i in case:
        print(i, end=" ")
    print()


# 구현2. 재귀를 통한 구현
def combination(depth, start):
    if depth == M:
        cases.append(temp.copy())
        return

    for i in range(start, N):
        temp[depth] = i + 1
        combination(depth + 1, i + 1)


N, M = map(int, input().split())
temp = [0] * M
cases = []
combination(0, 0)

for case in cases:
    for c in case:
        print(c, end=" ")
    print()
