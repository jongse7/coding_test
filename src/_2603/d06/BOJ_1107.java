package _2603.d06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int M = Integer.parseInt(br.readLine());

        String[] none = new String[M];

        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                none[i] = st.nextToken();
            }
        }

        int min = Math.abs(N - 100);

        for (int i = 0; i < 1000000; i++) {
            boolean conti = false;
            String channel = Integer.toString(i);
            for (int j = 0; j < M; j++) {
                if (channel.contains(none[j])) {
                    conti = true;
                }
            }
            if (conti) continue;
            int temp = channel.length() + Math.abs(N - i);
            min = Math.min(temp, min);
        }

        System.out.print(min);
    }
}
