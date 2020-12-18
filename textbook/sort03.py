# 두 배열의 원소교체

# 배열의 원소의 갯수 N과 최대 바꿀수 있는 횟수 K가 주어질 때
# A의 모든 원소의 합이 최댓값을 출력하는 프로그램을 작성하시오

n, k = map(int,input().split())

a = map(int,input().split())
b = map(int, input().split())

a = sorted(a)
b = sorted(b, reverse=True)

# a는 수가 증가하고 b는 수가 감소하기 때문에 같은 값이 나오는 곳이 존재한다면 반복을 끝내도 된다

for i in range(k):
    if a[i] < b[i]:
        a[i] , b[i] = b[i] , a[i]
    else:
        break

print(sum(a))
