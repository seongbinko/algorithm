from collections import deque

# 미로 탈출

n,m = map(int, input().split())

graph = []
for _ in range(n):
    graph.append(list(map(int, input())))

dx = [-1,1,0,0]
dy = [0,0,-1,1]

def bfs (x,y):
    queue = deque()
    queue.append((x,y))

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            vx = x + dx[i]
            vy = y + dy[i]
            
            if (vx < 0 or vx >= n or vy < 0 or vy >= m) :
                continue
            if graph[vx][vy] == 0:
                continue
            if graph[vx][vy] == 1:
                graph[vx][vy] = graph[x][y] + 1
                queue.append((vx,vy))

    return graph[n-1][m-1]

print(bfs(0,0))
