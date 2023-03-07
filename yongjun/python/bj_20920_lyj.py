from collections import Counter
import sys

input = sys.stdin.readline

N, M = map(int, input().split())

words = []
for i in range(N):
    data = input().rstrip()
    if len(data) >= M:
        words.append(data)

counter = Counter(words)
words = sorted(counter.items(), key=lambda x: (-x[1], -len(x[0]), x[0]))
for word in words:
    print(word[0])
