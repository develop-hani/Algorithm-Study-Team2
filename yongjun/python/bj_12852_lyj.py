

from collections import deque


def bfs(start, visited):
    queue = deque()

    r = set()
    r.add(start)
    queue.append((start, 0, r))
    visited[start] = True

    while queue:
        now, count, route = queue.popleft()

        if now == 1:
            return count, route

        for i in range(3):
            _next = -1
            if i == 0:
                if now % 3 == 0:
                    _next = now // 3

            elif i == 1:
                if now % 2 == 0:
                    _next = now // 2

            elif i == 2:
                _next = now - 1

            if now >= 0 and not visited[_next]:
                visited[_next] = True
                queue.append((_next, count + 1, route.union({_next})))


N = int(input())

visited = [False] * (N + 1)
res, route = bfs(N, visited)

route = sorted(route, reverse=True)
print(res)

for i in route:
    print(i, end=" ")
