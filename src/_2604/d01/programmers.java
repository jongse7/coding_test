package _2604.d01;
import java.util.*;

public class programmers {
}

// 두 정수 사이의 합 : level 1
class Solution1 {
    public long solution(int a, int b) {
        long answer = 0;
        int s = Math.min(a,b);
        int e = Math.max(a,b);
        for(int i = s; i <= e; i++){
            answer += i;
        }
        return answer;
    }
}

// 문자열을 정수로 바꾸기 : level 1
class Solution2 {
    public int solution(String s) {
        int answer = Integer.parseInt(s);
        return answer;
    }
}

// 약수의 합 : level 1
class Solution3 {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i++) if(n % i == 0) answer += i;
        return answer;
    }
}

// 자릿수 더하기 : level 1
class Solution4 {
    public int solution(int n) {
        int answer = 0;
        while(n > 0){
            answer += n % 10;
            n /= 10;
        }
        return answer;
    }
}

// 자연수 뒤집어 배열로 만들기 : level 1
class Solution5 {
    public int[] solution(long n) {
        int[] answer;
        long t = n;
        int l = 0;
        while(t > 0){
            t /= 10;
            l++;
        }
        answer = new int[l];
        int i = 0;
        while(n > 0){
            answer[i] = (int)(n % 10);
            n /= 10;
            i++;
        }
        return answer;
    }
}

// 정수 내림차순으로 배치하기 : level 1
class Solution6 {
    public long solution(long n) {
        long answer = 0;

        long t = n;
        int l = 0;
        while(t > 0){
            t /= 10;
            l++;
        }

        int[] temp = new int[l];

        int i = 0;
        while(n > 0){
            temp[i] = (int)(n % 10);
            n /= 10;
            i++;
        }

        Arrays.sort(temp);

        for(int j = 0; j < l; j++){
            answer += (long) temp[j] * (long) Math.pow(10, j);
        }

        return answer;
    }
}

// 정수 제곱근 판별 : level 1
class Solution7 {
    public long solution(long n) {
        long answer = 0;

        for(int i = 1; i <= n; i++){
            if((long) Math.pow(i,2) == n){
                answer = (long) Math.pow(i + 1, 2);
                break;
            }
        }

        return answer == 0 ? -1 : answer;
    }
}

// 짝수와 홀수 : level 1
class Solution8 {
    public String solution(int num) {
        String answer = num % 2 == 0 ? "Even" : "Odd";
        return answer;
    }
}

// 평균 구하기 : level 1
class Solution9 {
    public double solution(int[] arr) {
        double answer = 0;
        for(int i : arr){
            answer += (double)i;
        }

        answer /= (double) arr.length;

        return answer;
    }
}

// 하샤드 수 : level 1
class Solution10 {
    public boolean solution(int x) {
        boolean answer = true;

        int sum = 0;
        int t = x;
        while(t > 0){
            sum += t % 10;
            t /= 10;
        }

        answer = x % sum == 0;

        return answer;
    }
}