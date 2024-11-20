import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int cnt = 0;
    public static int N;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = -1;
        }

        dfs( 0);
        System.out.println(cnt);
    }

    // N개의 너비를 가진 체스판에 N개의 퀸을 배치하려면, x축마다 하나씩 퀸을 놓을 수밖에 없다.
    // 이러한 점을 이용하여 일차원 배열을 사용해 N개의 퀸의 위치를 저장한다. 인덱스에는 x좌표, 값에는 y좌표를 저장한다.
    public static void dfs (int dept) {
        int x = dept;
        if (N == dept) {
            cnt++;
            return;
        }
        for (int y = 0; y < N; y++) {
            boolean isPossible = isPossible(x,y);
            if (isPossible) {
                arr[x] = y;
                dfs(dept + 1);
                arr[x] = -1; // 백트래킹
            }
        }
    }
    
    public static boolean isPossible (int x, int y) {
        // 가로 방향 확인. 그동안 배치한 퀸들과 y값이 겹치는지 확인한다.
        for (int i = 0; i < x; i++) {
            if (arr[i] == y)
                return false;
        }
        // 대각선 방향 확인. 차의 절댓값이 같으면 대각선 방향에 있음을 이용하였다.
        for (int i = 0; i < x; i++) {
            if (Math.abs(x - i) == Math.abs(y - arr[i]))
                return false;
        }
        return true;
    }
}
