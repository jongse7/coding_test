package _2604.d06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014 {
    static class State {
        int v;
        int c;

        State(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }

    static int F;
    static int S;
    static int G;
    static int U;
    static int D;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        graph = new ArrayList[F + 1];
        visit = new boolean[F + 1];
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= F; i++) {
            graph[i] = new ArrayList<>();
            if (i + U <= F) {
                graph[i].add(i + U);
            }
            if (i - D > 0) {
                graph[i].add(i - D);
            }
        }
        solution();

        if (!visit[G]) System.out.print("use the stairs");
        else {
            System.out.print(result);
        }
    }

    static void solution() {
        Queue<State> q = new LinkedList<>();
        q.offer(new State(S, 0));
        visit[S] = true;
        while (!q.isEmpty()) {
            State now = q.poll();
            int nowV = now.v;
            int nowC = now.c;
            if (now.v == G) {
                result = Math.min(result, nowC);
            }
            for (int next : graph[nowV]) {
                if (!visit[next]) {
                    q.offer(new State(next, nowC + 1));
                    visit[next] = true;
                }
            }
        }
    }
}
