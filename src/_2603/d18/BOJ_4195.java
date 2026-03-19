package _2603.d18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_4195 {
    static int[] network;
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int F = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            network = new int[F * 2 + 1];
            size = new int[F * 2 + 1];
            for (int i = 1; i <= F * 2; i++) {
                network[i] = i;
                size[i] = 1;
            }

            int id = 0;
            for (int i = 0; i < F; i++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                int id1;
                int id2;

                if (map.containsKey(a)) {
                    id1 = map.get(a);
                } else {
                    id++;
                    map.put(a, id);
                    id1 = id;
                }
                if (map.containsKey(b)) {
                    id2 = map.get(b);
                } else {
                    id++;
                    map.put(b, id);
                    id2 = id;
                }
                System.out.println(union(id1, id2));
            }
        }
    }

    static int find(int id) {
        if (network[id] == id) return id;
        return network[id] = find(network[id]);
    }

    static int union(int a, int b) {
        int f1 = find(a);
        int f2 = find(b);
        if (f1 != f2) {
            network[f2] = f1;
            size[f1] += size[f2];
        }
        return size[f1];
    }
}
