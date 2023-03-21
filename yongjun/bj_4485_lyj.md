문제 회고를 위해 알고리즘 풀이 기록을 남깁니다.

# 백준 문제번호 문제제목
[4485 녹색 옷 입은 애가 젤다지?](https://www.acmicpc.net/problem/4485)

### 문제 이해하기
N X N 크기의 2차원 배열이 주어질 때 각각 (0, 0) -> (N-1, N-1)까지
최소한의 비용으로 이동하면 얼마의 비용이 나오는지 구하는 문제이다.
이동은 상, 하, 좌, 우로만 이동할 수 있다.

### 문제 접근 방법
1. 가중치가 주어지고, 최소비용 즉, 최소거리를 구하는 문제이기 때문에 다익스트라
알고리즘으로 접근하였다.

2. 현재 위치에서 상, 하, 좌, 우로 이동해서 도착할 수 있는 위치가 갈 수 있는
노드이기 때문에 2차원 배열을 선언하고 해당 좌표에서 갈 수 있으면 (nx, ny, 비용)
을 담아서 2차원 인접리스트를 생성하였고 이를 다익스트라 알고리즘을 적용해서 정답을 구하였다.
   
### 구현 배경 지식
1. 다익스트라 알고리즘


### 접근 방법을 적용한 코드
```python
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

```

