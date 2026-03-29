package _2603.d29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1009 {
    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int[] A = new int[5];
            for (int j = 1; j <= 4; j++) {
                A[j] = (int) Math.pow(a, j) % 10;
            }

            int t = b % 4;

            int r = A[t == 0 ? 4 : t];
            System.out.println(r == 0 ? 10 : r);
        }
    }
}
