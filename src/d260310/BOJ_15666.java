package d260310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15666 {
    static int N;
    static int M;
    static int[] A;
    static Set<String> set = new LinkedHashSet<>();
    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        ArrayList<Integer> a = new ArrayList<>();
        backtracking(a);

        for(String child : set){
            System.out.println(child);
        }
    }

    static void backtracking(ArrayList<Integer> a) {
        if(a.size() > 1 && a.get(a.size() - 1) < a.get(a. size() - 2)){
            return;
        }
        if (a.size() == M) {
            String temp = "";
            for(int child : a) {
                temp += child + " ";
            }
            set.add(temp);
        } else {
            for (int i = 0; i < N; i++) {
                a.add(A[i]);
                backtracking(a);
                a.remove(a.size() - 1);
            }
        }
    }
}
