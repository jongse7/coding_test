package _2603.d23;

import java.util.*;
import java.io.*;

public class BOJ_2816 {
    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int one = -1;
        int two = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.equals("KBS1")) {
                one = i;
            }
            if (input.equals("KBS2")) {
                if(one == -1) two = i + 1;
                else two = i;
            }
        }

        for (int i = 0; i < one; i++) System.out.print("1");
        for (int i = 0; i < one; i++) {
            System.out.print("4");
        }
        for (int i = 0; i < two; i++) {
            System.out.print("1");
        }
        for (int i = 0; i < two - 1; i++) {
            System.out.print("4");
        }
    }
}
