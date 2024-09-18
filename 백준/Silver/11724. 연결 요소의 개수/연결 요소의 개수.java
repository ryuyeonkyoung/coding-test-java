import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<ArrayList<Integer>> list;
    public static int[] visited;
    public static int cnt = 0;
    public static void dfs(int i){
        //if 더 나아갈 길이 없다면 cnt++하고 return
        // 더 나아갈 길이 없으면 돌아와서 다른 데꺼 탐색하겠지..?
        if (visited[i] == 1)
            return;

        //아니면 탐색하기
        visited[i] = 1;
        for (int next:list.get(i)) {
            if (visited[next] == 0) {
                dfs(next);
            }
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        visited = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            list.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < N + 1; i++) {
            visited[i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i] == 0) {
                cnt++;
                dfs(i);
            }
        }

        System.out.println(cnt);

    }
}