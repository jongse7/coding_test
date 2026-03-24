package _2603.d24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2512 {
    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] fat = new int[N];
        for (int i = 0; i < N; i++) fat[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(fat);

        int money = Integer.parseInt(br.readLine());

        int min = 0;
        int max = fat[N - 1];
        int result = 0;
        while (min <= max) {
            int mid = (min + max) / 2;

            int temp = 0;
            for (int i = 0; i < N; i++) {
                if (fat[i] < mid) temp += fat[i];
                else temp += mid;
            }

            if (temp > money) {
                max = mid - 1;
            } else if (temp == money) {
                result = mid;
                break;
            } else {
                min = mid + 1;
                result = mid;
            }
        }
        System.out.print(result);
    }
}
