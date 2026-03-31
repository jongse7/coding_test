package _2603.d31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        char game = st.nextToken().charAt(0);
        int t = 0;
        int r = 0;
        if (game == 'Y') t = 1;
        else if (game == 'F') t = 2;
        else if (game == 'O') t = 3;

        HashSet<String> played = new HashSet<>();
        ArrayList<String> gamers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            if (played.contains(name)) {
                continue;
            } else {
                played.add(name);
                gamers.add(name);
                if (gamers.size() == t) {
                    gamers.clear();
                    r++;
                }
            }
        }
        System.out.print(r);
    }
}
