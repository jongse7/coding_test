package d260317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(st.nextToken());
            A[i] = sum;
        }

        int[] A2 = new int[N - X + 1];
        for (int i = -1; i < N - X; i++) {
            int temp;
            if (i == -1) {
                temp = A[X - 1];
            } else {
                temp = A[X + i] - A[i];
            }
            A2[i + 1] = temp;
        }
        Arrays.sort(A2);


        int max = A2[A2.length - 1];
        if (max == 0) {
            System.out.print("SAD");
        } else {
            int count = 1;

            for (int i = A2.length - 2; i >= 0; i--) {
                if (A2[i] == max) count++;
                else break;
            }
            System.out.println(max);
            System.out.print(count);
        }
    }
}
