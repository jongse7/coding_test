package d260127;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            LinkedList<int[]> queue = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                queue.add(new int[] { j, Integer.parseInt(st.nextToken())});
            }
            int count = 0;
            while(!queue.isEmpty()){
                int[] current = queue.poll();
                boolean isMax = true;
                for(int[] page : queue){
                    if(current[1] < page[1]){
                        isMax = false;
                        break;
                    }
                }
                if(isMax){
                    count++;
                    if(current[0] == M){
                        System.out.println(count);
                        break;
                    }
                }else{
                    queue.offer(current);
                }
            }
        }
    }
}
