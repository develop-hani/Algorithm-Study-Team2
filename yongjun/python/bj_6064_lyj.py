T = int(input())
for t in range(T):
    M, N, x, y = map(int, input().split())

    visited = set()

    a = x - 1
    b = x - 1
    count = x
    success = False
    while True:
        resA = (a % M) + 1
        resB = (b % N) + 1

        if resA == x and resB == y:
            success = True
            break

        if (resA, resB) not in visited:
            visited.add((resA, resB))
        else:
            break

        count += M
        a += M
        b += M

    if success:
        print(count)
    else:
        print(-1)
