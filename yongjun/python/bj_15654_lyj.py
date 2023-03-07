from itertools import permutations

N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
cases = permutations(arr, M)
for case in cases:
    for c in case:
        print(c, end=" ")
    print()
