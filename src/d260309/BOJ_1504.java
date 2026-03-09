package d260309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504 {
    static class Node implements Comparable<Node> {
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
    static int[] dist;
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = sti(st.nextToken());
        int E = sti(st.nextToken());

        dist = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = sti(st.nextToken());
            int b = sti(st.nextToken());
            int c = sti(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = sti(st.nextToken());
        int v2 = sti(st.nextToken());

        dijkstra(1);
        int toV1 = dist[v1];
        int toV2 = dist[v2];
        initDist();
        dijkstra(v1);
        int v1ToV2 = dist[v2];
        int v1ToN = dist[N];
        initDist();
        dijkstra(v2);
        int v2ToN = dist[N];

        long route1 = (long) toV1 + v1ToV2 + v2ToN;
        long route2 = (long) toV2 + v1ToV2 + v1ToN;
        long result = Math.min(route1, route2);

        if (result >= Integer.MAX_VALUE || result <= 0) {
            System.out.print(-1);
        } else {
            System.out.print(result);
        }

    }

    static int sti(String n) {
        return Integer.parseInt(n);
    }

    static void initDist() {
        for (int i = 0; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int nowV = now.v;
            int nowCost = now.cost;
            if (nowCost > dist[nowV]) continue;
            for (Node next : graph[nowV]) {
                int nextCost = nowCost + next.cost;
                if (nextCost < dist[next.v]) {
                    dist[next.v] = nextCost;
                    pq.offer(new Node(next.v, nextCost));
                }
            }
        }
    }
}
