package _2603.d16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12919 {
    static String T;
    static boolean can;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        T = br.readLine();

        util(S, false);
        System.out.print(can ? '1' : '0');
    }

    static void util(String st, boolean flip) {
        if (T.contains(st) || T.contains(reverse(st))) {
            if ((st.equals(T) && !flip) || (reverse(st).equals(T) && flip)) {
                can = true;
            } else if (st.length() >= T.length()) {
                return;
            } else {
                if (flip) {
                    String case1 = "A" + st;
                    util(case1, true);

                    String case2 = "B" + st;
                    util(case2, false);
                } else {
                    String case3 = st + "A";
                    util(case3, false);

                    String case4 = st + "B";
                    util(case4, true);
                }
            }
        }
    }

    static String reverse(String st) {
        String result = "";
        for (int i = st.length() - 1; i >= 0; i--) {
            result += st.charAt(i);
        }

        return result;
    }
}
