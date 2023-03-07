from itertools import product

N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()

cases = product(arr, repeat=M)
for case in cases:
    for c in case:
        print(c, end=" ")
    print()