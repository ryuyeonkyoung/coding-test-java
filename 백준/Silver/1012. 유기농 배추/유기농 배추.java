import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int M;
    public static int N;
    public static int K;
    public static int count = 0;
    public static int[][] field;
    public static boolean[][] visited;

    public static void dfs (int x, int y) {
        // 방문한 곳 체크
        visited[x][y] = true;

        // 모여있는 배추 방문
        if (x > 0)
            if (field[x-1][y] == 1 && !visited[x-1][y])
                dfs(x-1, y);
        if (y > 0)
            if (field[x][y-1] == 1 && !visited[x][y-1])
                dfs(x,y-1);
        if (x+1 < M)
            if (field[x+1][y] == 1 && !visited[x+1][y])
                dfs(x+1, y);
        if (y+1 < N)
            if (field[x][y+1] == 1 && !visited[x][y+1])
                dfs(x, y+1);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 및 연산
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            count = 0;

            // 자바 배열은 자료형에 따라 기본값으로 자동 초기화된다.
            // int: 0, boolean: false, 참조형: null
            field = new int[M][N];
            visited = new boolean[M][N];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[x][y] = 1;
            }

            // counting
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (field[j][k] == 1 && !visited[j][k]) {
                       // System.out.print(j + "," + k + "\n");
                        dfs(j,k);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        // 출력
        System.out.println(sb);
    }
}
