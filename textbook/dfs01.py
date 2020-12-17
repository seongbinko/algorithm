# 음료수 얼려먹기

n,m = map(int,input().split())

graph = []

for _ in range(n):
    graph.append(list(map(int, input())))

def dfs(x,y):
    # 주어진 범위를 벗어나는 경우에는 즉시 종료
    if x <= -1 or x >= n or y <= -1 or y >= m:
        return False
    if graph[x][y] == 0:
        # 해당 노드 방문처리
        graph[x][y] = 1

        dfs(x-1,y)
        dfs(x+1,y)
        dfs(x,y-1)
        dfs(x,y+1)
        return True
    return False




# 모든 노드(위치)에 대하여 음료수 채우기
result = 0
for i in range(n):
    for j in range(m):
        # 현재 위치에서 DFS 수행
        if dfs(i,j) == True:
            result += 1

print(result)

# list(map(int,input())) 햇갈릴 때 참조
# http://blog.naver.com/PostView.nhn?blogId=pyjune&logNo=221914092466