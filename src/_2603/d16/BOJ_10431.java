package _2603.d16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int P = Integer.parseInt(br.readLine());
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            ArrayList<Integer> students = new ArrayList<>();
            for (int j = 0; j < 20; j++) students.add(Integer.parseInt(st.nextToken()));

            int count = 0;
            for (int j = 0; j < 20; j++) {
                int now = students.get(j);
                for (int k = 0; k < j; k++) {
                    if (now < students.get(k)) {
                        students.remove(j);
                        students.add(k, now);
                        count += j - k;
                        break;
                    }
                }
            }

            sb.append(T).append(" ").append(count).append("\n");
        }
        System.out.print(sb);
    }
}
