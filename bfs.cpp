#include <bits/stdc++.h>

using namespace std;

int main() {
    // Fast IO
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m, u, v, src, dest;
    cin >> n >> m;

    vector<int> graph[n + 1];
    bool visited[n + 1];
    for (int i = 0; i < m; i++) {
        cin >> u >> v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }

    cin >> src >> dest;

    // BFS
    queue<pair<int, int>> q;
    memset(visited, 0, sizeof visited);
    bool found = 0;
    q.push({src, 0});
    while (!q.empty()) {
        auto node = q.front();
        q.pop();
        visited[node.first] = 1;
        if (node.first == dest) {
            cout << node.second << '\n';
            found = 1;
            break;
        }

        for (int neigh: graph[node.first]) {
            if (!visited[neigh]) {
                q.push({neigh, node.second + 1});
                visited[neigh] = 1;
            }
        }
    }

    if (!found) {
        cout << 0 << '\n';
    }

    return 0;
}
