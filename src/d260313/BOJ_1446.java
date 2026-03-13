package d260313;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1446 {
    static public class Node implements Comparable<Node> {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int N;
    static int D;
    static ArrayList<Node>[] graph;
    static int[] dist;
    static int INF = 10001;

    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        graph = new ArrayList[INF];
        dist = new int[INF];
        for (int i = 0; i < INF; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for (int i = 0; i < D + 1; i++) {
            graph[i].add(new Node(i + 1, 1));
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, cost));
        }

        dijkstra(0);
        System.out.print(dist[D]);

    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int nowV = now.v;
            if (nowV == D) break;
            int nowCost = now.cost;
            if (dist[nowV] < nowCost) continue;
            for (Node next : graph[nowV]) {
                int nextV = next.v;
                int nextCost = next.cost + nowCost;
                if (dist[nextV] > nextCost) {
                    pq.offer(new Node(nextV, nextCost));
                    dist[nextV] = nextCost;
                }
            }
        }
    }
}
