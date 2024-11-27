import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static Queue<Integer> q = new LinkedList<>();
    public static List<LinkedList<Integer>> list;
    public static boolean[] visited;
    public static int start;
    public static int end;
    public static int dfs (int n, int cnt) {
        // 1. 방문 처리
        visited[n] = true;

        if (n == end) return cnt;

        for (int a : list.get(n)) {
            if (!visited[a]) {
                visited[a] = true;
                int result = dfs(a, cnt+1);
                if (result != -1) {
                    return result;
                }
                visited[a] = false;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];
        list = new LinkedList<>();
        for (int i = 0; i < n+1; i++) {
            list.add(new LinkedList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        System.out.println(dfs(start, 0));
    }
}