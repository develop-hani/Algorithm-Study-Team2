def binary_search(arr, start, end):
    res = -1
    while start <= end:
        mid = (start + end) // 2

        temp = mid
        fail = False
        for i in range(N):
            temp += arr[i][0]
            if temp > arr[i][1]:
                fail = True
                break

        if fail:
            end = mid - 1
        else:
            res = mid
            start = mid + 1

    return res


N = int(input())

arr = []
for i in range(N):
    arr.append(list(map(int, input().split())))

end = -1
for i in range(N):
    end = max(end, arr[i][1])

arr.sort(key=lambda x: x[1])

answer = binary_search(arr, 0, end)
print(answer)
