import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static LinkedList<LinkedList<Integer>> list;
    public static boolean visited[];
    public static Queue<Integer> q = new LinkedList<>();
    public static void dfs (int n) {
        visited[n] = true;
        sb.append(n).append(" ");

        for (int a : list.get(n))
            if (!visited[a])
                dfs(a);
    }
    public static void bfs (int n) {
        // 큐에 초기 노드를 넣고 시작
        q.offer(n);
        visited[n] = true;

        // 스택 채우기
        while (!q.isEmpty()) {
            n = q.poll();
            sb.append(n).append(" ");

            for (int a : list.get(n)) {
                if (!visited[a]) {
                    q.offer(a);
                    visited[a] = true; // 큐에 넣는 시점에서 visited 체크해야 중복이 안생김.
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        list = new LinkedList<>();
        visited = new boolean[N+1];
        for (int i = 0; i < N+1; i++) {
            visited[i] = false;
        }

        // 인접리스트 만들기
        for (int i = 0; i < N+1; i++) {
            list.add(new LinkedList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        for (int i = 0; i < N + 1; i++) {
            if (!list.get(i).isEmpty())
                Collections.sort(list.get(i));
        }

        // dfs수행
        dfs(V);
        sb.append("\n");

        for (int i = 0; i < N+1; i++)
            visited[i] = false;
        bfs(V);

        System.out.println(sb);
    }
}