package _2604.d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        String input2 = br.readLine();

        int il = input.length();
        int c4l = input2.length();
        if (il < c4l) {
            System.out.print(input);
        } else {
            ArrayList<Character> stack = new ArrayList<>();
            ArrayList<Character> c4 = new ArrayList<>();
            for (int i = 0; i < c4l; i++) {
                c4.add(input2.charAt(i));
            }
            int s = 0;

            for (int i = 0; i < il; i++) {
                char c = input.charAt(i);
                stack.add(c);
                s++;
                if (s >= c4l) {
                    String temp = "";
                    for (int j = c4l; j > 0; j--) {
                        if (stack.get(s - j) == c4.get(c4l - j)) {
                            temp += stack.get(s - j);
                        }
                    }
                    if (temp.equals(input2)) {
                        for (int j = c4l; j > 0; j--) {
                            stack.remove(s - j);
                            s--;
                        }
                    }
                }
            }

            if (stack.isEmpty()) {
                System.out.print("FRULA");
            } else {
                for (char c : stack) {
                    sb.append(c);
                }
                System.out.print(sb);
            }
        }
    }
}
