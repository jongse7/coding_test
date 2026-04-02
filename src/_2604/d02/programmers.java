package _2604.d02;

public class programmers {
    // x만큼 간격이 있는 n개의 숫자
    public long[] solution1(int x, int n) {
        long[] answer = new long[n];
        for (int i = 0; i < n; i++) {
            answer[i] = (long) x * (i + 1);
        }
        return answer;
    }

    // 나머지가 1이 되는 수 찾기
    public int solution2(int n) {
        int answer = 0;

        for (int i = 2; i < 1000000; i++) {
            if (n % i == 1) {
                {
                    answer = i;
                    break;
                }
            }
        }

        return answer;
    }

    // 문자열 내 p와 y의 개수
    boolean solution3(String s) {
        int p = 0;
        int y = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == 'p' || c == 'P') p++;
            else if(c == 'y' || c == 'Y') y++;
        }

        return p == y;
    }
    public int solution4(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i = 0; i < signs.length; i++){
            answer += signs[i] ? absolutes[i] : -absolutes[i];
        }

        return answer;
    }

}
