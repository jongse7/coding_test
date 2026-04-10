package _2604.d09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BOJ_9012 {
    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Character> stack;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            stack = new LinkedList<>();
            String input = br.readLine();
            int l = -1;
            for (int j = 0; j < input.length(); j++) {
                char t = input.charAt(j);
                stack.add(t);
                if (l >= 0 && t == ')' && stack.get(l) == '(') {
                    stack.removeLast();
                    stack.removeLast();
                    l -= 2;
                }
                l++;
            }
            System.out.println(stack.isEmpty() ? "YES" : "NO");
        }
    }
}
