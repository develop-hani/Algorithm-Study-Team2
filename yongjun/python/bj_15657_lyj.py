from itertools import combinations_with_replacement

N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
cases = combinations_with_replacement(arr, M)
for case in cases:
    for c in case:
        print(c, end=" ")
    print()
