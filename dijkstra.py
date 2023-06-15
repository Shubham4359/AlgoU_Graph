public static long[] dijkstra(int src, List<List<Pair>> graph){
	    long[] dist = new long[graph.size()];
	    Arrays.fill(dist, Long.MAX_VALUE);
	    dist[src] = 0;
	    
	    PriorityQueue<Pair> pq = new PriorityQueue<>();
	    pq.add(new Pair(src, 0));
	    
	    while(pq.size() > 0){
	        Pair p = pq.poll();
	        int u = p.node;
	        
	        for(Pair child: graph.get(u)){
	            long w = child.weight;
	           // System.out.println(u + " - " + child.node + " " + w);
	            if(dist[u] + w < dist[child.node]){
	                dist[child.node] = dist[u] + w;
	                pq.add(new Pair(child.node, dist[u] + w));
	            }
	        }
	    }
	    
	    return dist;
	}
