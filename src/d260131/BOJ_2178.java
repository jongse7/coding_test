package d260131;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
    static int N;
    static int M;
    static int[][] miro;
    static boolean[][] visited;
    static int[][] dirs = {{1,0},{-1,0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        miro = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                miro[i][j] = line.charAt(j) - '0';
            }
        }
        bfs();
        System.out.print(miro[N-1][M-1]);
    }
    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int [] {0,0});
        while(!q.isEmpty()){
            int[] point = q.poll();
            for(int[] dir : dirs){
                int x = point[0] + dir[0];
                int y = point[1] + dir[1];
                if(x >=0 && y >= 0 && x < N && y < M && miro[x][y] == 1 && !visited[x][y]){
                    miro[x][y] = miro[point[0]][point[1]] + 1;
                    visited[x][y] = true;
                    q.offer(new int[]{x,y});
                }
            }

        }
    }
}
