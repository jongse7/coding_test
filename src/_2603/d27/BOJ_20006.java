package _2603.d27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_20006 {

    static int p;
    static int m;

    static class Member implements Comparable<Member> {
        int l;
        String n;

        public Member(int l, String n) {
            this.l = l;
            this.n = n;
        }

        @Override
        public int compareTo(Member o) {
            return this.n.compareTo(o.n);
        }
    }

    static class Room {
        int min;
        int max;
        ArrayList<Member> members;

        public Room(int n) {
            this.min = n - 10;
            this.max = n + 10;
            this.members = new ArrayList<>();
        }

        public boolean isMax() {
            return this.members.size() == m;
        }

        public void isStarted() {
            Collections.sort(members);
            if (isMax()) {
                System.out.println("Started!");
                for (Member m : this.members) {
                    System.out.println(m.l + " " + m.n);
                }
            } else {
                System.out.println("Waiting!");
                for (Member m : this.members) {
                    System.out.println(m.l + " " + m.n);
                }
            }
        }
    }

    static ArrayList<Room> matching = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();
            Member member = new Member(l, n);
            boolean isMatching = false;
            for (Room child : matching) {
                int min = child.min;
                int max = child.max;
                int size = child.members.size();
                if (l >= min && l <= max && size < m) {
                    child.members.add(member);
                    isMatching = true;
                    break;
                }
            }
            if (!isMatching) {
                Room r = new Room(l);
                r.members.add(member);
                matching.add(r);
            }
        }
        for (Room child : matching) {
            child.isStarted();
        }
    }
}
