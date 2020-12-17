# 큰수의 법칙 p92

# N,M, K를 공백으로 구분하여 입력받기
n, m, k = map(int, input().split())

data = list(map(int, input().split()))
data.sort()  # 데이터 정렬

_k = 0

result = 0
# for _ in range(m):
#   if(_k != k):
#     result += data[-1]
#     _k += 1
#   else:
#     result += data[-2]
#     _k = 0


# 수열로 파악했을 때
# m // (k+1) * k
count = int(m / (k + 1)) * k
count += m % (k + 1)

result += (count) * data[-1]
result += (m - count) * data[-2]

print(result)
