# 구현1. combinations_with_replacement 사용
from itertools import combinations_with_replacement

N, M = map(int, input().split())

arr = [i for i in range(1, N + 1)]
cases = combinations_with_replacement(arr, M)
for case in cases:
    for c in case:
        print(c, end=" ")
    print()


# 구현2. 재귀를 통한 구현
def combinations_with_replacement(depth, start):
    if depth == M:
        cases.append(temp.copy())
        return

    for i in range(start, N):
        temp[depth] = i + 1
        combinations_with_replacement(depth + 1, i)


N, M = map(int, input().split())
temp = [0] * M
cases = []
combinations_with_replacement(0, 0)
for case in cases:
    for c in case:
        print(c, end=" ")
    print()
