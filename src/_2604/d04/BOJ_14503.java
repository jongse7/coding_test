package _2604.d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503 {
    static int N;
    static int M;
    static int I;
    static int J;
    static int D;
    static int[][] map;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        I = Integer.parseInt(st.nextToken());
        J = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            // 1 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if (map[I][J] == 0) {
                map[I][J] = 2;
                result++;
            }

            if (isTrash()) {
                rotate();
                scanAndMove();
            } else {
                // 2 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
                // 2-1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
                if (move(-1)) {
                    continue;
                } else {
                    // 2-2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
                    break;
                }
            }
        }
        System.out.print(result);
    }

    static boolean rangeI(int dist) {
        return I + dist >= 0 && I + dist < N;
    }

    static boolean rangeJ(int dist) {
        return J + dist >= 0 && J + dist < M;
    }

    static boolean move(int dist) {
        if (D == 0) {
            if (rangeI(1) && map[I + 1][J] != 1) {
                I++;
            } else return false;
        } else if (D == 1) {
            if (rangeJ(-1) && map[I][J - 1] != 1) {
                J--;
            } else return false;
        } else if (D == 2) {
            if (rangeI(-1) && map[I - 1][J] != 1) {
                I--;
            } else return false;
        } else if (D == 3) {
            if (rangeJ(1) && map[I][J + 1] != 1) {
                J++;
            } else return false;
        }
        return true;
    }

    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static boolean isTrash() {
        for (int[] d : dir) {
            int nx = I + d[0];
            int ny = J + d[1];
            if (rangeI(d[0]) && rangeJ(d[1])) {
                if (map[nx][ny] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    static void rotate() {
        D--;
        if (D < 0) D = 3;
    }

    static void scanAndMove() {
        if (D == 0) {
            if (rangeI(-1) && map[I - 1][J] == 0) I--;
        } else if (D == 1) {
            if (rangeJ(1) && map[I][J + 1] == 0) J++;
        } else if (D == 2) {
            if (rangeI(1) && map[I + 1][J] == 0) I++;
        } else if (D == 3) {
            if (rangeJ(-1) && map[I][J - 1] == 0) J--;
        }
    }
}
