package d260203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889 {
    static int N;
    static int[][] table;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        table = new int[N][N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) table[i][j] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        System.out.print(result);
    }
    static void dfs(int next, int count){
        if(count == N/2){
            calculate();
        }else{
            for(int i = next; i < N; i++){
                visited[i] = true;
                dfs(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }
    static void calculate(){
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visited[i] && visited[j]){
                    sum1 += table[i][j];
                }
                if(!visited[i] && !visited[j]){
                    sum2 += table[i][j];
                }
            }
        }
        result = Math.min(result, Math.abs(sum1 - sum2));
    }
}
