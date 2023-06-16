def dfs(node, adj_list, visited, leaf_sum):
    visited[node] = True
    is_leaf = True
    for neighbor in adj_list[node]:
        if not visited[neighbor]:
            is_leaf = False
            leaf_sum = dfs(neighbor, adj_list, visited, leaf_sum)
    if is_leaf:
        leaf_sum += 1
    return leaf_sum


n, x = map(int, input().split())

adj_list = [[] for _ in range(n+1)]


for i in range(n-1):
    u, v = map(int, input().split())
    adj_list[u].append(v)
    adj_list[v].append(u)

visited = [False] * (n+1)
leaf_sum = dfs(1, adj_list, visited, 0)
print(leaf_sum)
