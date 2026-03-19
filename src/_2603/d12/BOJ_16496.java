package _2603.d12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16496 {
    static class BigNumber implements Comparable<BigNumber> {
        String n;

        public BigNumber(String n) {
            this.n = n;
        }

        @Override
        public int compareTo(BigNumber o) {
            String ab = n + o.n;
            String ba = o.n + n;

            return ba.compareTo(ab);
        }
    }

    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<BigNumber> A = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A.add(new BigNumber(st.nextToken()));
        }

        if (A.peek().n.equals("0")) {
            System.out.print("0");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(A.poll().n);
            }
            System.out.print(sb);
        }
    }
}
