import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();

        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>(n+1);

        for (int i = 1; i <= n+1; i++) {
            adjlist.add(new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            int node1 = input.nextInt();
            int node2 = input.nextInt();

            adjlist.get(node1).add(node2);
            adjlist.get(node2).add(node1);
        }

        int src = input.nextInt();

        int target = input.nextInt();

        int[] dest = bfs(adjlist, src, n);

        if (dest[target] != 0){
            System.out.println(dest[target]);
        }else {
            System.out.println(0);
        }

    }

    private static int[] bfs(ArrayList<ArrayList<Integer>> adjlist, int src, int n) {
        Queue<Integer> que = new LinkedList<>();

        boolean[] visited = new boolean[n+1];

        int[] dist = new int[n+1];

        dist[src] = 0;
        visited[src] = true;

        que.offer(src);

        while (!que.isEmpty()){
            int curr = que.peek();
            
            que.poll();

            for (int x: adjlist.get(curr)
                 ) {
                if (visited[x] == false){
                    visited[x] = true;
                    dist[x] = dist[curr] + 1;
                    que.offer(x);
                }
            }
            
        }

        return dist;
        
    }
}
