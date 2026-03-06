package d260306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18917 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long sum = 0;
        long xorSum = 0;
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            switch(Integer.parseInt(st.nextToken())){
                case 1 : {
                    int temp = Integer.parseInt(st.nextToken());
                    sum += temp;
                    xorSum ^= temp;
                    break;
                }
                case 2 : {
                    int temp = Integer.parseInt(st.nextToken());
                    sum -= temp;
                    xorSum ^= temp;
                    break;
                }
                case 3 : {
                    System.out.println(sum);
                    break;
                }
                case 4 : {
                    System.out.println(xorSum);
                    break;
                }
            }
        }
    }
}
