package _2604.d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_20055 {
    static class Node {
        int hp;
        boolean robot;

        Node(int hp) {
            this.hp = hp;
            this.robot = false;
        }
    }

    static int N;
    static LinkedList<Node> container = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            container.add(new Node(Integer.parseInt(st.nextToken())));
        }

        int step = 1;
        while (true) {
            // 1
            Node last = container.removeLast();
            container.addFirst(last);

            down();

            // 2
            for (int i = N - 2; i >= 0; i--) {
                Node node = container.get(i);
                Node node2 = container.get(i + 1);
                if (node.robot && !node2.robot && node2.hp >= 1) {
                    node.robot = false;
                    node2.robot = true;
                    node2.hp--;
                }
            }
            down();

            // 3
            Node first = container.get(0);
            if (!first.robot && first.hp > 0) {
                first.robot = true;
                first.hp--;
            }

            // 4
            int zero = 0;
            for (Node node : container) {
                if (node.hp == 0) {
                    zero++;
                }
            }
            if (zero >= K) break;
            step++;
        }
        System.out.print(step);
    }

    static void down() {
        Node down = container.get(N - 1);
        if (down.robot) {
            down.robot = false;
        }
    }
}
