package d260311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_13913 {
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

    static int INF = Integer.MAX_VALUE;
    static int range;
    static int[] dist;
    static int[] path;
    static int K;

    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        range = 1000001;

        dist = new int[range];
        path = new int[range];
        for (int i = 0; i < range; i++) {
            dist[i] = INF;
        }

        dijkstra(N);
        System.out.println(dist[K]);

        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int i = K;
        while (i != N) {
            stack.push(path[i]);
            i = path[i];
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
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
            if (dist[nowV] < nowCost) continue;
            if (nowV == K) break;
            Node[] nexts = {new Node(nowV + 1, nowCost + 1), new Node(nowV - 1, nowCost + 1), new Node(nowV * 2, nowCost + 1)};
            for (Node next : nexts) {
                if (next.v == -1 || next.v >= range) continue;
                int nextV = next.v;
                int nextCost = next.cost;
                if (dist[nextV] > nextCost) {
                    pq.offer(new Node(nextV, nextCost));
                    dist[nextV] = nextCost;
                    path[nextV] = nowV;
                }
            }
        }
    }
}
