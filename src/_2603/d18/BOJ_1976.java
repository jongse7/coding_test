package _2603.d18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976 {
    static int[] cities;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        cities = new int[N + 1];

        int M = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) cities[i] = i;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int d = Integer.parseInt(st.nextToken());
                if (d == 1) union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int now = cities[Integer.parseInt(st.nextToken())];
        boolean can = true;
        for (int i = 1; i < M; i++) {
            int next = cities[Integer.parseInt(st.nextToken())];
            if (isUnion(now, next)) continue;
            else {
                can = false;
                break;
            }
        }
        System.out.print(can ? "YES" : "NO");
    }

    static int find(int n) {
        if (cities[n] == n) return n;
        return cities[n] = find(cities[n]);
    }

    static void union(int a, int b) {
        int c1 = find(a);
        int c2 = find(b);
        if (c1 != c2) {
            cities[c1] = c2;
        }
    }

    static boolean isUnion(int a, int b) {
        int c1 = find(a);
        int c2 = find(b);
        return c1 == c2;
    }
}
