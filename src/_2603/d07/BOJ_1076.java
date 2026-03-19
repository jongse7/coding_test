package _2603.d07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class BOJ_1076 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
        List<String> list = Arrays.asList(colors);

        long v1 = list.indexOf(br.readLine());
        long v2 = list.indexOf(br.readLine());
        long v3 = list.indexOf(br.readLine());

        long result = (v1 * 10 + v2) * (long) Math.pow(10, v3);

        System.out.println(result);
    }
}
