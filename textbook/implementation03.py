#왕실의 나이트
import time

input_data = input()

start_time = time.time()

x = int(input_data[1])

y = input_data[0]


y_list = "0abcdefgh"

y = int(y_list.index(y))


dx = [-2,-2,-1,1,2,2,1,-1]
dy = [-1, 1, 2,2,1,-1,-2,-2]

count = 0
for i in range(8):
    if x + dx[i] > 0 and y + dy[i] > 0 and  x + dx[i] < 9 and y + dy[i] < 9:
        count = count +1
print(count)

end_time = time.time()
print("time :", end_time - start_time)