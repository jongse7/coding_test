package d260126;

import java.util.*;
import java.io.*;

public class BOJ_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new HashMap<String, String>();
        HashMap<String, String> map2 = new HashMap<String, String>();
        for(int i = 1; i <= N; i++){
            String pokemon = br.readLine();
            map.put(Integer.toString(i), pokemon);
            map2.put(pokemon, Integer.toString(i));
        }

        for(int i = 0; i < M; i++){
            String search = br.readLine();
            if(map.containsKey(search)) System.out.println(map.get(search));
            else System.out.println(map2.get(search));
        }
    }
}

