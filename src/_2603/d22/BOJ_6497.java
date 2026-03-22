package _2603.d22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_6497 {
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Node o) {
            return this.z - o.z;
        }
    }

    static int[] parent;
    static PriorityQueue<Node> graph = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int m;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) break;

            parent = new int[m];
            for (int i = 0; i < m; i++) parent[i] = i;

            int before = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                graph.add(new Node(x, y, z));
                before += z;
            }

            int after = 0;
            while (!graph.isEmpty()) {
                Node now = graph.poll();
                int x = now.x;
                int y = now.y;
                int z = now.z;
                if (find(x) == find(y)) continue;
                else {
                    union(x, y);
                    after += z;
                }
            }
            System.out.println(before - after);
        }

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
