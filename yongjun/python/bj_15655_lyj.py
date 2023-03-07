from itertools import combinations

N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
cases = combinations(arr, M)


for case in cases:
    for c in case:
        print(c, end=" ")
    print()