import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static Queue<int[]> q = new LinkedList<>();
    public static int[][] miro;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int N = 0;
    public static int M = 0;
    public static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        miro = new int[N][M];
        visited = new boolean[N][M];
        cnt = N*M;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                miro[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0,0);
        System.out.println(miro[N-1][M-1]);
    }
    // 네 방향으로 탐색할 때는 주로 bfs가 효율적인 경우가 많다 (최단 경로 탐색, 레벨 단위 탐색)
    public static void bfs (int x, int y) {
        // 큐에 초기 노드를 넣고 시작
        q.offer(new int[] {x, y});
        visited[x][y] = true;

        // 큐가 빌 때까지 (bfs가 끝날 때까지)
        while (!q.isEmpty()) {
            // poll해서 x,y좌표 꺼내기
            int[] current = q.poll();
            int currentX = current[0];
            int currentY = current[1];

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                // 기존 좌표에 벡터 더해서 상하좌우로 이동
                int nX = currentX + dx[i];
                int nY = currentY + dy[i];

                // 예외 1. 범위 안에 없으면 continue
                if (nX < 0 || nX >= N || nY < 0 || nY >= M)
                    continue;
                // 예외 2. 벽(0)이면 continue
                if (miro[nX][nY] == 0)
                    continue;
                // 예외 3. 방문했으면 continue
                if (visited[nX][nY])
                    continue;

                q.offer(new int[] {nX, nY});
                visited[nX][nY] = true;
                // 미로의 각 길에 지나야 하는 칸 수를 기록하면서 bfs 진행.
                // bfs가 끝난 후 도착 지점에 저장된 숫자를 출력하기만 하면 된다.
                miro[nX][nY] = miro[currentX][currentY] + 1;
            }
        }
    }

    public static void dfs (int x, int y, int dept) { // 시간 초과
        // 1. 이미 방문했을 경우 return
        if (visited[x][y]) return;
        else visited[x][y] = true;
        // 2. 이미 최단거리보다 길게 온 경우 return
        if (dept >= cnt) {
            visited[x][y] = false;
            return;
        }
        // 3. 목적지에 도착한 경우 return
        if(x == N-1 & y == M-1) {
            cnt = Math.min(cnt, dept);
            visited[x][y] = false;
            return;
        }

        // 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];
            if (nX >= 0 && nX < N && nY >= 0 && nY < M) {
                if (miro[nX][nY] == 1) {
                    dfs(nX, nY, dept+1);
                }
//                visited[nextX][nextY] = false; // 위치가 잘못됨. 모든 경로를 탐색한 후에 방문 해제를 해야함.
            }
        }
        visited[x][y] = false; // 백트래킹
    }
}