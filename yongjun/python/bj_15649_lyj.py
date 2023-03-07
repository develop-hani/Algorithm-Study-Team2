from itertools import permutations

N, M = map(int, input().split())

arr = [i for i in range(1, N + 1)]
cases = permutations(arr, M)

for case in cases:
    for c in case:
        print(c, end=" ")
    print()
