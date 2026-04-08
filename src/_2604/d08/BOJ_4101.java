package _2604.d08;
import java.util.*;
import java.io.*;

public class BOJ_4101 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if (first == 0 && second == 0) {
                break;
            }

            if (first > second) {
                sb.append("Yes\n");
            } else {
                sb.append("No\n");
            }
        }

        System.out.print(sb.toString());
    }
}