package d260201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11724 {
    static LinkedList<Integer>[] graph;
    static boolean[] visited;
    static int N;
    static int M;
    static int output;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new LinkedList[N + 1];
        for (int i = 0; i < N + 1; i++) graph[i] = new LinkedList<>();
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            graph[l].add(r);
            graph[r].add(l);
        }
        bfs();
        System.out.print(output);
    }

    static void bfs() {
        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            else {
                output++;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                visited[i] = true;
                while (!queue.isEmpty()) {
                    int e = queue.poll();
                    for (int child : graph[e]) {
                        if (!visited[child]) {
                            visited[child] = true;
                            queue.offer(child);
                        }
                    }

                }
            }
        }
    }
}
