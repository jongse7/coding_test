package d260305;
import java.util.*;
import java.io.*;

public class BOJ_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(A);
        int left = 0;
        int right = N - 1;
        int left_point = 0;
        int right_point = 0;
        int result = Integer.MAX_VALUE;
        while (left < right) {
            int temp = A[left] + A[right];
            if (result > Math.abs(temp)) {
                left_point = left;
                right_point = right;
                result = Math.abs(temp);
            }
            if (temp > 0) {
                right--;
            } else if (temp < 0) {
                left++;
            } else {
                left_point = left;
                right_point = right;
                break;
            }
        }
        System.out.print(A[left_point] + " " + A[right_point]);
    }
}
