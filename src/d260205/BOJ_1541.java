package d260205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BOJ_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        LinkedList<String> list = new LinkedList<>();

        int point = 0;
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '-'){
                list.add(input.substring(point, i));
                point = i + 1;
            }
        }
        list.add(input.substring(point));

        int sum = 0;
        for(int i = 0; i < list.size(); i++){
            if(i == 0) sum += util(list.get(i));
            else sum -= util(list.get(i));
        }
        System.out.print(sum);
    }
    static int util(String e){
        int result = 0;
        int point = 0;
        for(int i = 0; i < e.length(); i++){
            if(e.charAt(i) == '+'){
                result += Integer.parseInt(e.substring(point, i));
                point = i + 1;
            }
        }
        result += Integer.parseInt(e.substring(point));
        return result;
    }
}
