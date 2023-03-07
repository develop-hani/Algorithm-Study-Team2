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