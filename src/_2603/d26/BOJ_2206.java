package _2603.d26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {
    static class Node {
        int x;
        int y;
        int dist;
        int broken;

        public Node(int x, int y, int dist, int broken) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.broken = broken;
        }
    }

    static int N;
    static int M;
    static boolean[][][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];


        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                int v = line.charAt(j) - '0';
                map[i][j] = v;
            }
        }

        visit = new boolean[N][M][2];
        bfs(map);
    }

    static int[][] nexts = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void bfs(int[][] map) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1, 0));
        visit[0][0][0] = true;
        while (!q.isEmpty()) {
            Node now = q.poll();
            int nowX = now.x;
            int nowY = now.y;
            int nowD = now.dist;
            int broken = now.broken;
            if (nowX == N - 1 && nowY == M - 1) {
                System.out.print(nowD);
                return;
            }
            for (int[] next : nexts) {
                int nextX = nowX + next[0];
                int nextY = nowY + next[1];
                if (range(nextX, nextY)) {
                    if (!visit[nextX][nextY][broken] && map[nextX][nextY] == 0) {
                        q.offer(new Node(nextX, nextY, nowD + 1, broken));
                        visit[nextX][nextY][broken] = true;
                    } else if (broken == 0 && !visit[nextX][nextY][1] && map[nextX][nextY] == 1) {
                        q.offer(new Node(nextX, nextY, nowD + 1, 1));
                        visit[nextX][nextY][1] = true;
                    }
                }
            }
        }
        System.out.print(-1);

    }

    static boolean range(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= M) {
            return false;
        }
        return true;
    }
}
