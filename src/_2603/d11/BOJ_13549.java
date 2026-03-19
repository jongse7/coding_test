package _2603.d11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13549 {
    static class Node implements Comparable<Node> {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.v - o.v;
        }
    }

    static ArrayList<Node>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int temp = Math.max(N, K);
        int range = 2 * temp + 1;
        int INF = 1000001;

        graph = new ArrayList[range * 2 + 1];
        dist = new int[range * 2 + 1];

        for (int i = 0; i <= range; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }
        for (int i = 0; i <= range; i++) {
            graph[i].add(new Node(i - 1, 1));
            graph[i].add(new Node(i + 1, 1));
            graph[i].add(new Node(i * 2, 0));
        }
        dijkstra(N);
        System.out.print(dist[K]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int nowV = now.v;
            int nowCost = now.cost;
            if (dist[nowV] < nowCost) continue;
            for (Node next : graph[nowV]) {
                int nextV = next.v;
                if (nextV == -1) continue;
                int nextCost = nowCost + next.cost;
                if (dist[nextV] > nextCost) {
                    pq.offer(new Node(nextV, nextCost));
                    dist[nextV] = nextCost;
                }
            }
        }
    }
}
