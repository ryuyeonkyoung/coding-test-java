import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, M;
    public static boolean[] visited;
    public static int[] out;
    public static void permute(int dept) {
        if (dept == M) {
            // dept에 도달하면 out 출력
            for (int o:out) {
                System.out.print(o + " ");
            }
            System.out.print("\n");
        } else {
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    out[dept] = i+1;
                    permute(dept + 1);

                    visited[i] = false; // 백트래킹
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        out = new int[M];

        permute(0);
    }
}