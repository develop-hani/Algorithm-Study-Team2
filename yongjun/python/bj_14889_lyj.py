from itertools import combinations

N = int(input())

arr = []
for i in range(N):
    data = list(map(int, input().split()))
    arr.append(data)

res = 1e9
numbers = [i for i in range(N)]
cases = combinations(numbers, N // 2)
for case in cases:
    left_power = 0
    left_cases = combinations(case, 2)
    right_numbers = {i for i in range(N)}
    for left_case in left_cases:
        left_power += arr[left_case[0]][left_case[1]]
        left_power += arr[left_case[1]][left_case[0]]
        right_numbers -= {left_case[0]}
        right_numbers -= {left_case[1]}

    right_power = 0
    right_cases = combinations(right_numbers, 2)
    for right_case in right_cases:
        right_power += arr[right_case[0]][right_case[1]]
        right_power += arr[right_case[1]][right_case[0]]
    res = min(res, abs(left_power - right_power))
print(res)
