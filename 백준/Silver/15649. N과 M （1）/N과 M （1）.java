import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void permute(int[] arr, int[] out, boolean[] visited, int dept) {
        int n = arr.length;
        if (dept == out.length) {
            // dept에 도달하면 out 출력
            for (int o:out) {
                System.out.print(o + " ");
            }
            System.out.print("\n");
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    out[dept] = arr[i];
                    permute(arr, out, visited, dept + 1);
                    visited[i] = false; // 백트래킹
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        boolean[] visited = new boolean[N];
        int[] out = new int[M];
        Arrays.setAll(arr,i -> i+1);

        permute(arr, out ,visited, 0);
    }
}