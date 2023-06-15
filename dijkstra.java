import java.io.*;
import java.util.*;

public class Main
{
  static class Pair implements Comparable<Pair>{
      int node;
      long weight;

      Pair(int node, long weight){
          this.node = node;
          this.weight = weight;
      }
      
      public int compareTo(Pair p){
          return Long.compare(weight, p.weight); 
      }
  }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		
		int N = Integer.parseInt(in[0]);
		int M = Integer.parseInt(in[1]);
		
		List<List<Pair>> graph = new ArrayList<List<Pair>>();
		for(int i = 0; i <= N; i++){
		    graph.add(new ArrayList<Pair>());
		}
		
		for(int i = 0; i < M; i++){
		    in = br.readLine().split(" ");
		    int u = Integer.parseInt(in[0]);
		    int v = Integer.parseInt(in[1]);
		    int f = Integer.parseInt(in[2]);
		    graph.get(u).add(new Pair(v, f));
		}
		
		long[] dist1 = dijkstra(1, graph);
	}
	
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
}
