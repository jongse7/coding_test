package d260306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> ppq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> mpq = new PriorityQueue<>();
        int zero = 0;

        for(int i = 0; i < N; i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp > 0){
                ppq.offer(temp);
            }else if (temp < 0){
                mpq.offer(temp);
            }else{
                zero++;
            }
        }

        int result = 0;
        while(mpq.size() > 1){
            int first = mpq.poll();
            int second = mpq.poll();
            int temp = first * second;
            result += temp;
        }
        if(mpq.size() == 1){
            if(zero == 0){
                result += mpq.poll();
            }
        }

        while(ppq.size() > 1){
            int first = ppq.poll();
            int second = ppq.poll();
            int temp = first * second;
            result += temp == first ? first + 1: temp;
        }
        if(ppq.size() == 1){
            result += ppq.poll();
        }
        System.out.print(result);
    }
}
