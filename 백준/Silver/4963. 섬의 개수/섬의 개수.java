import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.*;

public class Main {
    public static int[][] map;
    public static boolean[][] visited;
    // 상하좌우 및 대각선으로 이동하기 위해 벡터 이용
    public static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    public static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static int cnt;
    public static int w, h;

    public static void dfs (int x, int y) {
        // 1. 방문 처리
        visited[x][y] = true;

        // 2. 주변에 있는 섬들 다 방문 처리하기
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue; // break 쓰면 안됨
            else if (!visited[nx][ny] && map[nx][ny] == 1) dfs(nx, ny);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 입력
        while (true) {
            cnt = 0;
            // w,h 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break; // 0,0이면 break;

            // map, visited 생성
            map = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // dfs
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        dfs(i,j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }



        System.out.println(sb.toString());
    }
}