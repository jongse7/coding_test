package _2603.d27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6593 {
    static class Node {
        int x;
        int y;
        int z;
        int t;

        Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.t = 0;
        }

        Node(int x, int y, int z, int t) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.t = t;
        }
    }

    static int x;
    static int y;
    static int z;
    static int min;

    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            String input = br.readLine();
            if (input.equals("0 0 0")) break;
            st = new StringTokenizer(input);

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());

            char[][][] map = new char[x][y][z];
            boolean[][][] visit = new boolean[x][y][z];
            Node start = new Node(0, 0, 0);
            min = Integer.MAX_VALUE;

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < z; k++) {
                        char c = s.charAt(k);
                        map[i][j][k] = c;
                        if (c == 'S') start = new Node(i, j, k);
                    }
                }
                String temp = br.readLine();
            }

            bfs(start, map, visit);

            System.out.println(min == Integer.MAX_VALUE ? "Trapped!" : "Escaped in " + min + " minute(s).");
        }
    }

    static Node[] dir = {new Node(1, 0, 0), new Node(0, 1, 0), new Node(0, 0, 1), new Node(-1, 0, 0), new Node(0, -1, 0), new Node(0, 0, -1)};

    static void bfs(Node start, char[][][] map, boolean[][][] visit) {
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        visit[start.x][start.y][start.z] = true;
        while (!q.isEmpty()) {
            Node now = q.poll();
            int nowX = now.x;
            int nowY = now.y;
            int nowZ = now.z;
            int nowT = now.t;
            for (Node next : dir) {
                int newX = nowX + next.x;
                int newY = nowY + next.y;
                int newZ = nowZ + next.z;
                if (isRange(newX, newY, newZ)) {
                    if (map[newX][newY][newZ] != '#' && !visit[newX][newY][newZ]) {
                        if (map[newX][newY][newZ] == 'E') {
                            min = Math.min(min, nowT + 1);
                        } else {
                            q.offer(new Node(newX, newY, newZ, nowT + 1));
                            visit[newX][newY][newZ] = true;
                        }
                    }
                }
            }
        }
    }

    static boolean isRange(int a, int b, int c) {
        if (a < 0 || b < 0 || c < 0 || a >= x || b >= y || c >= z) return false;
        else return true;
    }

}
