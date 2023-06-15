import java.io.*;
import java.util.*;
public class Main {
 
	static HashMap<Integer,ArrayList<Node>> adjList = new HashMap<>();
	
	static class Node{
	    public int dest;
	    public long weight;
	    public Node(int to, long weight){
		    this.dest = to;
		    this.weight = weight;
	    }
	
	
	    public long getWeight(){
	    	return this.weight;
	    }
	}

	public static void main(String[] args) throws IOException{
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	    String[] s = br.readLine().trim().split(" ");
	    int nodes =Integer.parseInt(s[0]);
	    int edges =Integer.parseInt(s[1]);
	    for(int i = 1; i <= nodes ; i++){
	    	adjList.put(i,new ArrayList<Node>());
	    }
	    while(edges-->0){
	    	s=br.readLine().trim().split(" ");
	    	int src = Integer.parseInt(s[0]);
	    	int d = Integer.parseInt(s[1]);
	    	long w = Long.parseLong(s[2]);
	    	adjList.get(src).add(new Node(d,w));
	    }
	    long[] sorceDijktra = Dijkstra(adjList,1,nodes);
	}

	public static long[] Dijkstra(HashMap<Integer,ArrayList<Node>> adjList,int src, int nodes){
	    boolean[] visited = new boolean[nodes+1];
	    long[] distance = new long[nodes+1];
	    Arrays.fill(distance,Integer.MAX_VALUE);
	    Comparator<Node> NodeComparator= Comparator.comparingLong(Node::getWeight);
	    PriorityQueue<Node> qu = new PriorityQueue<>(NodeComparator);
	    qu.add(new Node(src,0));
	    while(!qu.isEmpty()){
		    Node source = qu.remove();
		    if(visited[source.dest])
		    continue;
		    visited[source.dest] = true;
		    distance[source.dest]=source.getWeight();
		    for(Node neighbour : adjList.get(source.dest)){
		    	qu.add(new Node(neighbour.dest,source.getWeight()+neighbour.getWeight()));
		    }
	    }
	    return distance;
	}
}
