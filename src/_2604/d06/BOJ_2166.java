package _2604.d06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        long[] xa = new long[N];
        long[] ya = new long[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Integer.parseInt(st.nextToken());
            long y = Integer.parseInt(st.nextToken());
            xa[i] = x;
            ya[i] = y;
        }

        double fs = 0;
        double bs = 0;

        for (int i = 0; i < N - 1; i++) {
            fs += xa[i] * ya[i + 1];
            bs += ya[i] * xa[i + 1];
        }
        fs += xa[N - 1] * ya[0];
        bs += ya[N - 1] * xa[0];

        double solution = Math.abs(fs - bs) / 2.0;
        String result = String.format("%.1f", solution);
        System.out.print(result);
    }
}
