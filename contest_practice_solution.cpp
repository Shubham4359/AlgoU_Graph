#include <bits/stdc++.h>
using namespace std;


int dfs(int node, vector<vector<int>>& adj_list, vector<bool>& visited) {
    visited[node] = true;
    bool is_leaf=true;
    int total = 0;
    for (int child : adj_list[node]) {
        if (!visited[child]) {
           is_leaf=false;
           total+= dfs(child, adj_list, visited);
        }
    }
    if(is_leaf){
        return 1;
    }
    return total;
}

int main() {
    int N;
    cin >> N;
    
    vector<vector<int>> adj_list(N + 1);
    vector<bool> visited(N + 1, false);

    for (int i = 1; i<N; i++) {
        int a, b;
        cin >> a >> b;
        adj_list[a].push_back(b);
    }
    
    
  
    int sum = dfs(1, adj_list, visited);
    cout<<sum<<"\n";
    
    return 0;
}
