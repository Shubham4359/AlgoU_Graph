import collections

tempStr = (input().strip()).split()
nodeCount = int(tempStr[0])
edgeCount = int(tempStr[1])
adj = dict()
distance = dict()
visited = dict()

for i in range(nodeCount):
    adj[i+1] = []
    distance[i+1] = 0
    visited[i+1] = 0

for i in range(edgeCount):
    tempStr = (input().strip()).split()
    a = int(tempStr[0])
    b = int(tempStr[1])
    adj[a].append(b)
    adj[b].append(a)

tempStr = (input().strip()).split()
startNode = int(tempStr[0])
finishNode = int(tempStr[1])

visited[startNode] = 1
queue = collections.deque([startNode])
while(len(queue) != 0):    
    if visited[finishNode] == 1:
        break;
        
    currNode = queue.popleft()
    #print("CurrNode : " + str(currNode))
    for node in adj[currNode]:
        if visited[node] == 0:
            visited[node] = 1
            queue.append(node)
            distance[node] = distance[currNode] + 1
            #print("Appending : " + str(node) + " distance " + str(distance[node]))

print(distance[finishNode])
