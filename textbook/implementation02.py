# 시각

# 정수 N이 입력되었을 때 N시 59분 59초 까지의 모든 시각 중에서 3이 하나라도 포함되는 모든 경우의 수를 구하는 프로그램을 작성하시오

import time

n = int(input())

start_time = time.time()

result = 0
for i in range(n + 1):
    for j in range(60):
        for k in range(60):
            value = str(i) + str(j) + str(k)
            if '3' in value:
                # if 0 != value.count('3'): 확실히 더 걸림
                result += 1

print(result)

end_time = time.time()
print("time :", end_time - start_time)
