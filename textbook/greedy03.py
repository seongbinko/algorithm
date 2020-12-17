# 숫자 카드게임
import time

n, m = map(int, input().split())

start_time = time.time()

temp = [0] * n
for i in range(n):
    data = list(map(int, input().split()))
    temp.append(min(data))
result = max(temp)

# result = 0
# for i in range(n):
#     data = list(map(int,input().split()))

#     min_value = min(data)
#     result = max(result, min_value)

end_time = time.time()

print(result)
print("time :", end_time - start_time)
