package d260309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {
    static class Node implements Comparable<Node>{
        int v;
        int cost;
        public Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    static int[] dist;
    static ArrayList<Node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb =  new StringBuilder();

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        dist = new int[V + 1];
        graph = new ArrayList[V + 1];
        for(int i = 1; i <= V; i++){
            dist[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            Node e = new Node(v, w);
            graph[u].add(e);
        }
        dijkstra(start);

        for(int i = 1; i <= V; i++) sb.append(dist[i] == Integer.MAX_VALUE ? "INF\n" : dist[i] + "\n");
        System.out.print(sb);
    }
    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        while(!pq.isEmpty()){
            Node nowNode = pq.poll();
            int now = nowNode.v;
            int nowCost = nowNode.cost;
            if(nowCost > dist[now]) continue;
            for(Node next : graph[now]){
                int nextCost = nowCost + next.cost;
                if(nextCost < dist[next.v]){
                    dist[next.v] = nextCost;
                    pq.offer(new Node(next.v, nextCost));
                }
            }
        }
    }
}
