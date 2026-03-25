package _2603.d25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14940 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] graph;
    static boolean[][] visit;
    static int[][] dist;
    static int n;
    static int m;

    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        dist = new int[n][m];
        visit = new boolean[n][m];

        Node start = new Node(0, 0);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());
                graph[i][j] = input;
                if (input == 2) start = new Node(i, j);
            }
        }
        bfs(start.x, start.y);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && dist[i][j] == 0) {
                    sb.append(-1);
                } else {
                    sb.append(dist[i][j]);
                }
                sb.append(' ');
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static int[][] nexts = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        visit[x][y] = true;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int nowX = now.x;
            int nowY = now.y;
            for (int[] next : nexts) {
                int nextX = nowX + next[0];
                int nextY = nowY + next[1];
                if (overflow(nextX, nextY) && graph[nextX][nextY] == 1 && !visit[nextX][nextY]) {
                    dist[nextX][nextY] = dist[nowX][nowY] + 1;
                    visit[nextX][nextY] = true;
                    queue.offer(new Node(nextX, nextY));
                }
            }
        }
    }

    static boolean overflow(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= m) {
            return false;
        }
        return true;
    }
}
