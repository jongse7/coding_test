package d260125;

import java.util.*;
import java.io.*;

public class BOJ_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        for(int i = 0; i < N; i++){
            String word = br.readLine();
            words[i] = word;
        }
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2){
                // 1. 길이 비교 : 길이가 짧은 것 우선
                if(s1.length() != s2.length()){
                    return s1.length() - s2.length();
                }
                // 2. 길이가 같으면 : 사전 순 (String의 compareTo 사용)
                return s1.compareTo(s2);
            }
        });
        for(int i = 0; i < N; i++){
            if(i != 0 && words[i].equals(words[i - 1])) continue;
            System.out.println(words[i]);
        }
    }
}
