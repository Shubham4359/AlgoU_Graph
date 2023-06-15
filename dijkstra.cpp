#include<bits/stdc++.h>
#define ll long long
using namespace std;

void dijkstra(ll src,vector<vector<pair<ll,ll>>> &g,vector<ll> &ans){
    ans[src] = 0;
    using pii = pair<ll, ll>;
    priority_queue<pii, vector<pii>, greater<pii>> q;
    q.push({0, src});
    while (!q.empty()){
        ll v = q.top().second;
        ll d_v = q.top().first;
        q.pop();
        if (d_v <= ans[v]){
        for (auto edge : g[v]) {
            ll to = edge.first;
            ll len = edge.second;

            if (ans[v] + len < ans[to]){
                ans[to] = ans[v] + len;
                q.push({ans[to], to});
            }
        }
        }
    }
}

int main (){
    ll n,m;
    cin>>n>>m;
    vector<vector<pair<ll,ll>>> g(n+1);
    for(ll i=1;i<=m;i++){
        ll u,v,w;
        cin>>u>>v>>w;
        g[u].push_back(make_pair(v,w));
    }
    vector<ll> ans(n+1,INT64_MAX);
    dijkstra(1,g,ans);
    cout<<ans[n]<<endl;
    return 0;
}
