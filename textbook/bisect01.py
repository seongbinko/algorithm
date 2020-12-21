# 부품찾기
n = int(input())
data1 = sorted(list(map(int,input().split())))

m = int(input())
data2 = list(map(int,input().split()))

def binary_search(arr1,target,start,end):
        while start <= end:
            mid = (start + end) // 2
            if data1[mid] == target:
               return mid
            elif data1[mid] > target:
                end = mid -1
            else:
                start = mid + 1
        return None

for i in data2:
    result = binary_search(data1, i, 0, n-1)
    if result != None:
        print('yes' , end=' ')
    else:
        print('no', end=' ')