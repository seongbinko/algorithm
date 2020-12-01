# 1이 될 때 까지

n, k = map(int,input().split())

result = 0

while(True):
    if n < k:
        break
    # if(n%k != 0):
    target = (n//k)*k
    result += (n-target)
    n = target
    continue
    result += 1
    n //= k

print(result)