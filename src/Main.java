import java.util.*;
import java.io.*;

public class Main {
    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> dq = new LinkedList<>();
        for(int i = 0; i < N; i++) dq.add(Integer.parseInt(st.nextToken()));

        int next = dq.poll() - 1;
        sb.append(1).append(" ");
        while(!dq.isEmpty()){
            if(next < 0){
                next = dq.size() + next;
                System.out.println(next);
            }else if(next >= dq.size()){
                next = next - dq.size() - 1;
            }
            int now = dq.get(next);
            System.out.println(now);

            sb.append(next).append(" ");
            dq.remove(next);
            next += now;
        }
        System.out.print(sb);
    }
}