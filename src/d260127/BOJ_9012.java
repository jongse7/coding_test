package d260127;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            String ps = br.readLine();
            Stack<Character> stack = new Stack<>();
            stack.push(ps.charAt(0));
            for(int j = 1; j < ps.length(); j++){
                // stack이 비어있다면 peek에서 예외를 낳으므로 isEmpty() 클래스로 비어있는지 검사 후 peek() 검사
                if(!stack.isEmpty() && stack.peek() == '(' && ps.charAt(j) == ')') stack.pop();
                else stack.push(ps.charAt(j));
            }
            if(stack.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
