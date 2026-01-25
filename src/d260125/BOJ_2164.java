package d260125;

import java.util.*;
import java.io.*;

public class BOJ_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) queue.offer(i);
        while(queue.size() != 1){
            queue.poll();
            int second = queue.poll();
            queue.offer(second);
        }
        System.out.print(queue.peek());
    }
}
