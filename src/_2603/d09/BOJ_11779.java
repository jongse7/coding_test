package _2603.d09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11779 {
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

    static int[] dist;
    static ArrayList<Node>[] graph;
    static int [] path;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        dist = new int[N + 1];
        graph = new ArrayList[N + 1];
        path = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[s].add(new Node(e, c));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start);

        int count = 1;
        ArrayList<Integer> cities = new ArrayList<>();
        int i = end;
        cities.add(i);
        while(i != start){
            int prev = path[i];
            cities.add(prev);
            count++;
            i = prev;
        }

        System.out.println(dist[end]);
        System.out.println(count);
        for(int j = cities.size() - 1; j >= 0; j--){
            System.out.print(cities.get(j) + " ");
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.v;
            int nowCost = node.cost;
            if (nowCost > dist[now]) continue;
            for (Node next : graph[now]) {
                int newV = next.v;
                int newCost = next.cost + nowCost;
                if (newCost < dist[newV]) {
                    pq.offer(new Node(newV, newCost));
                    dist[newV] = newCost;
                    path[newV] = now;
                }
            }
        }
    }
}
