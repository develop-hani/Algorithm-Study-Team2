import heapq


def dijkstra(graph, sx, sy, distance):
    hq = []
    heapq.heappush(hq, (sx, sy, distance[sx][sy]))
    while hq:
        x, y, dist = heapq.heappop(hq)

        for nx, ny, next_dist in graph[x][y]:
            cost = next_dist + dist
            if cost < distance[nx][ny]:
                distance[nx][ny] = cost
                heapq.heappush(hq, (nx, ny, cost))


dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

t = 1
while True:
    N = int(input())
    if N == 0:
        break

    arr = []
    graph = [[[] for _ in range(N)] for _ in range(N)]

    for i in range(N):
        arr.append(list(map(int, input().split())))

    for x in range(N):
        for y in range(N):
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < N and 0 <= ny < N:
                    graph[x][y].append((nx, ny, arr[nx][ny]))

    INF = 1e9
    distance = [[INF] * N for _ in range(N)]
    distance[0][0] = arr[0][0]
    dijkstra(graph, 0, 0, distance)

    answer = distance[N - 1][N - 1]
    print(f"Problem {t}: {answer}")
    t += 1
