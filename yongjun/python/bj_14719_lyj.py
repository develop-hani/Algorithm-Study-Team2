H, W = map(int, input().split())
data = list(map(int, input().split()))
graph = [[0] * W for _ in range(H)]

for y in range(W):
    for x in range(H - data[y], H):
        graph[x][y] = 1

answer = 0
for x in range(H):
    for y in range(W):
        if graph[x][y] == 0:

            find_wall = 0
            done = False
            # 왼쪽 탐색
            for ny in range(y, -1, -1):
                if graph[x][ny] == 1:
                    find_wall += 1
                    break

                if graph[x][ny] == 2:
                    graph[x][y] = 2
                    answer += 1
                    done = True
                    break

            if done:
                continue

            # 오른쪽 탐색
            for ny in range(y, W):
                if graph[x][ny] == 1:
                    find_wall += 1
                    break
                if graph[x][ny] == 2:
                    graph[x][y] = 2
                    answer += 1
                    break

            if find_wall == 2:
                graph[x][y] = 2
                answer += 1

print(answer)
