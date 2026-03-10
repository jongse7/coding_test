package d260310;

import java.util.*;
import java.io.*;


public class BOJ_15663 {
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
        boolean[] visit = new boolean[N];
        backtracking(a, visit);

        for (String child : set) {
            System.out.println(child);
        }
    }

    static void backtracking(ArrayList<Integer> a, boolean[] visit) {
        if (a.size() == M) {
            String temp = "";
            for (int child : a) {
                temp += child + " ";
            }
            set.add(temp);
        } else {
            for (int i = 0; i < N; i++) {
                if (visit[i]) continue;
                a.add(A[i]);
                visit[i] = true;
                backtracking(a, visit);
                visit[i] = false;
                a.remove(a.size() - 1);
            }
        }
    }
}
