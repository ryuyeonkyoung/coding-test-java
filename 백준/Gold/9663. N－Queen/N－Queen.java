import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int cnt = 0;
    public static int N;
    public static int[] arr;
    public static void dfs (int dept) {
        int x = dept; // x의 각 좌표별로 한개씩
        if (N == dept) {
            cnt++;
            return;
        }
        for (int y = 0; y < N; y++) {
            boolean isPossible = isPossible(x,y);
            if (isPossible) {
                arr[x] = y;
                dfs(dept + 1);
                arr[x] = -1; // 값 초기화 안해도 dept가 줄어드는거 자체가 백트래킹이다.
            }
        }
    }
    public static boolean isPossible (int x, int y) {
        // 그동안 한걸 봐야하므로 x의 비교범위는 0부터 x 이전까지이다.
        // y값 겹치는지 확인
        for (int i = 0; i < x; i++) {
            if (arr[i] == y)
                return false;
        }
        // 대각선 방향에 있는지 확인. 차의 절댓값이 같으면 대각선 방향에 있다.
        for (int i = 0; i < x; i++) {
            if (Math.abs(x - i) == Math.abs(y - arr[i]))
                return false;
        }
        return true;
    }
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
}