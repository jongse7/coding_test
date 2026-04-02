package _2604.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18429 {
    static int N;
    static int K;
    static int[] kits;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        kits = new int[N];
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            kits[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] visit = new boolean[N];
        backtracking(500, 0, visit);
        System.out.print(count);
    }

    static void backtracking(int weight, int day, boolean[] visit) {
        if (weight < 500) {
            return;
        }
        if (day == N) {
            count++;

        } else {
            for (int i = 0; i < N; i++) {
                int kit = kits[i];
                if (!visit[i]) {
                    visit[i] = true;
                    backtracking(weight + kit - K, day + 1, visit);
                    visit[i] = false;
                }
            }
        }
    }
}
