package d260130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606 {
    static int count;
    static boolean[] visited;
    static class Graph {
        LinkedList<Integer> link;
        Graph(LinkedList<Integer> link){
            this.link = link;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        Graph[] arr = new Graph[C + 1];
        for(int i = 0; i <= C; i++) arr[i] = new Graph(new LinkedList<>());
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            arr[n1].link.add(n2);
            arr[n2].link.add(n1);
        }
        visited = new boolean[C + 1];
        bfs(arr);
        System.out.print(count);
    }
    static void bfs (Graph[] graph){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int child : graph[now].link){
                if(!visited[child]){
                    queue.offer(child);
                    visited[child] = true;
                    count++;
                }
            }
        }
    }
}
