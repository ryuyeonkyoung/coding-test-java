import java.util.*;
import java.io.*;

public class Main {
    public static String goal = "123456780";
    public static String puzzle = "";
    public static Queue<String> q = new LinkedList<>();
    // key: 현재 퍼즐, value: 이동 횟수
    // goal이 key와 같으면 value의 최솟값을 갱신한다.
    public static Map<String, Integer> map = new HashMap<>();
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int bfs(String start) {
        q.offer(start);
        map.put(start, 0);

        while(!q.isEmpty()) {
            // 큐에서 하나를 꺼낸다.
            String curr = q.poll();
            int moveCnt = map.get(curr);

            // 목표에 도달했는지 확인한다.
            if (curr.equals(goal)) return moveCnt;

            // 상하좌우로 이동한다.
            int zeroIdx = curr.indexOf('0');
            int x = zeroIdx % 3;
            int y = zeroIdx / 3;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 좌표의 위치가 범위를 벗어나면 지나친다.
                if (nx < 0 || nx >= 3 || ny < 0 || ny >= 3) continue;
//                System.out.println("nx: " + nx + ", ny: " + ny);


                // 다음 좌표의 String 인덱스 계산
                int nextIdx = ny * 3 + nx;

                // 0과 다음 좌표의 수 swap
                char[] currToCharArray = curr.toCharArray();
                char temp = currToCharArray[zeroIdx];
                currToCharArray[zeroIdx] = currToCharArray[nextIdx];
                currToCharArray[nextIdx] = temp;
                String nextPuzzle = new String(currToCharArray);

                if (!map.containsKey(nextPuzzle)) {
                    map.put(nextPuzzle, moveCnt + 1);
                    q.offer(nextPuzzle);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                puzzle += st.nextToken();
            }
        }

        // 출력
        System.out.println(bfs(puzzle));

    }
}