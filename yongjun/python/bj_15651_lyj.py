# 구현1. product 사용
from itertools import product
N, M = map(int, input().split())

arr = [i for i in range(1, N+1)]
cases = product(arr, repeat=M)
for case in cases:
    for c in case:
        print(c, end=" ")
    print()


# 구현2. 재귀를 통한 구현
def product(depth):
    if depth == M:
        cases.append(temp.copy())
        return

    for i in range(N):
        temp[depth] = i + 1
        product(depth + 1)


N, M = map(int, input().split())
temp = [0] * M
cases = []
product(0)

for case in cases:
    for c in case:
        print(c, end=" ")
    print()
