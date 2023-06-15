import math
import heapq
import sys
n , m = map(int, sys.stdin.readline().split())
adjacency_list_dir = [[] for i in range(n+1)]


for i in range(m):
    u,v,c = map(int , sys.stdin.readline().split())
    adjacency_list_dir[u].append([v,c])

def dijkstra(q,d,adjacency_list):
    while(len(q)!=0):
        p=heapq.heappop(q)
        d_v=p[0]
        v=p[1]
       
        if(d_v!=d[v]):
           continue
    
        for edge in adjacency_list[v]:
           to=edge[0]
           cost=edge[1]
           
           if(d[v]+cost<d[to]):
               d[to]=d[v]+cost
               heapq.heappush(q,(d[to],to))
q=[]
heapq.heappush(q,(0,1))
d_src = [math.inf for i in range(n+1)]
d_src[1]=0
dijkstra(q,d_src,adjacency_list_dir)
a=[]
heapq.heappush(a,(0,n))
