import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int cnt = 0;
    public static int N;
    public static boolean[][] isEmpty;
    public static void dfs (int dept) {
        int x = dept; // x의 각 좌표별로 한개씩
        if (N == dept) {
            cnt++;
            return;
        }
        for (int y = 0; y < N; y++) {
            if (isPossible(x,y)) {
                isEmpty[x][y] = false;
                dfs(dept + 1);
                isEmpty[x][y] = true;
            }
        }
    }
    public static boolean isPossible (int x, int y) {
        int i, j;
        //해당 점
        if (!isEmpty[x][y])
            return false;
        // 세로/가로 방향에 있는지 확인
        for (i = 0; i < N; i++) {
            if (!isEmpty[i][y] || !isEmpty[x][i])
                return false;
        }
        // 대각선 방향에 있는지 확인
        for (i = x, j = y; i < N && j < N; i++, j++) {
            if (!isEmpty[i][j])
                return false;
        }
        for (i = x, j = y; i >= 0 && j < N; i--, j++) {
            if (!isEmpty[i][j])
                return false;
        }
        for (i = x, j = y; i < N && j >= 0; i++, j--) {
            if (!isEmpty[i][j])
                return false;
        }
        for (i = x, j = y; i >= 0 && j >= 0; i--, j--) {
            if (!isEmpty[i][j])
                return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        isEmpty = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                isEmpty[i][j] = true;
            }
        }

        dfs( 0);
        System.out.println(cnt);
    }
}