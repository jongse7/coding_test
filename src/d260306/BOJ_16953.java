package d260306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16953 {
    static long A;
    static long B;
    static long C = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        bt(A, 0);
        System.out.print(C == Integer.MAX_VALUE ? -1 : C + 1);
    }

    static void bt(long n, int count) {
        if (n == B) {
            C = Math.min(C, count);
        } else if (n < B) {
            bt(n * 2, count + 1);
            bt(n * 10 + 1, count + 1);
        }
    }
}
