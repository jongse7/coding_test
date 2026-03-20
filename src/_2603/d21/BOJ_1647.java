package _2603.d21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1647 {
    static class Node implements Comparable<Node> {
        int v1;
        int v2;
        int c;

        public Node(int v1, int v2, int c) {
            this.v1 = v1;
            this.v2 = v2;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            return this.c - o.c;
        }
    }

    static PriorityQueue<Node> graph;
    static int[] parent;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        graph = new PriorityQueue<>();
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph.add(new Node(A, B, C));
        }

        int last = 0;
        while (!graph.isEmpty()) {
            Node child = graph.poll();
            if (find(child.v1) == find(child.v2)) {
                continue;
            } else {
                result += child.c;
                last = child.c;
                union(child.v1, child.v2);
            }
        }

        System.out.print(result - last);
    }

    static int find(int n) {
        if (parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    static void union(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);
        if (p1 != p2) parent[p1] = p2;
    }
}
