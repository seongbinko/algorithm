# 위에서 아래로

n = int(input())

arr = []

for _ in range(n):
    arr.append(int(input()))

result = sorted(arr, reverse=True)

for i in result:
    print(i, end=' ')