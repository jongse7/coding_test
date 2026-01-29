package d260129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = N - 1;
            boolean isFound = false;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (target > A[mid]) {
                    start = mid + 1;
                } else if (target < A[mid]) {
                    end = mid - 1;
                } else {
                    isFound = true;
                    break;
                }
            }
            if (isFound) sb.append(1).append('\n');
            else sb.append(0).append('\n');
        }

        System.out.print(sb);
    }
}
