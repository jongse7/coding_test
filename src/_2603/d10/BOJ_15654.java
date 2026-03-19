package _2603.d10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15654 {
    static int N;
    static int M;
    static int[] A;
    static StringBuilder sb = new StringBuilder();

    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        ArrayList<Integer> a = new ArrayList<>();
        backtracking(a);
        System.out.print(sb);
    }

    static void backtracking(ArrayList<Integer> a) {
        if (a.size() == M) {
            for (int i = 0; i < a.size(); i++) {
                sb.append(a.get(i)).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 0; i < N; i++) {
                if (a.contains(A[i])) continue;
                a.add(A[i]);
                backtracking(a);
                a.remove(a.size() - 1);
            }
        }
    }
}
