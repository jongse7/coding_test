package _2603.d18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (c == 0) {
                union(a, b);
            } else if (c == 1) {
                System.out.println(isUnion(a, b) ? "YES" : "NO");
            }
        }

    }

    static int find(int n) {
        if (n == parent[n]) return n;
        return parent[n] = find(parent[n]);
    }

    static void union(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);

        if (p1 != p2) {
            parent[p1] = p2;
        }
    }

    static boolean isUnion(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);

        return p1 == p2;
    }
}
