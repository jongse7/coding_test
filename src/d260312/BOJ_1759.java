package d260312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
    static public class Node {
        ArrayList<Character> words;
        int n;
        int m;

        public Node(int n, int m) {
            this.words = new ArrayList<>();
            this.n = n;
            this.m = m;
        }
    }

    static int L;
    static int C;
    static ArrayList<Character> m = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    static char[] words;
    static StringBuilder sb;

    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        words = new char[C];
        for (int i = 0; i < C; i++) {
            words[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(words);

        Node node = new Node(0, 0);
        backtracking(node, 0);
        System.out.print(sb);
    }

    static void backtracking(Node node, int start) {
        if (node.words.size() == L) {
            if (node.m >= 1 && node.n >= 2) {
                for (char word : node.words) {
                    sb.append(word);
                }
                sb.append("\n");
            } else {
                return;
            }
        } else {
            for (int i = start; i < words.length; i++) {
                char temp = words[i];
                if (node.words.contains(temp)) continue;

                if (m.contains(temp)) node.m += 1;
                else node.n += 1;
                node.words.add(temp);

                backtracking(node, i + 1);

                if (m.contains(temp)) node.m -= 1;
                else node.n -= 1;
                node.words.remove(node.words.size() - 1);
            }
        }
    }
}
