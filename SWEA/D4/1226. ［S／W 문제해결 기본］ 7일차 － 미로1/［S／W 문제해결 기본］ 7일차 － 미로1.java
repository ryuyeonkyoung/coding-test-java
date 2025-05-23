
import java.io.FileInputStream;
import java.util.Scanner;

//1226. [S/W 문제해결 기본] 7일차 - 미로1
public class Solution {

	static char[][] charWall;
	static boolean[][] wall;
	static boolean[][] visited;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int startX;
	static int startY;
	static int goalX;
	static int goalY;
	static int canReach = 0;

	public static boolean isInBoundary(int x, int y) {

		if (0 <= x && x < 16 && 0 <= y && y < 16) return true;
		return false;
	}

	public static void dfs(int x, int y) {
		if (x == goalX && y == goalY) canReach = 1;

		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (!isInBoundary(nx, ny)) continue;
			if (!wall[nx][ny] && !visited[nx][ny]) {
//				System.out.println("nx: " + nx + ", ny: " + ny);
				visited[nx][ny] = true;
				dfs(nx, ny);
				visited[nx][ny] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/1226_input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = 10; // 추후 10으로 바꾸기
		for (int test_case = 1; test_case <= T; test_case++) {
			charWall = new char[16][16];
			wall = new boolean[16][16];
			visited = new boolean[16][16];
			canReach = 0;

			// 입력
			sc.next();
			for(int i=0; i<16; i++) {
				String s = sc.next();
				charWall[i] = s.toCharArray();
			}

			// 변환
			for(int i=0; i<16; i++) {
				for(int j=0; j<16; j++) {
					int n = charWall[i][j] - '0';
					if (n == 1) wall[i][j] = true;

					if (n == 2) {
						startX = i;
						startY = j;
					} else if (n == 3) {
						goalX = i;
						goalY = j;
					}
				}
			}

			dfs(startX,startY);

			// 출력
			System.out.println("#" + test_case + " " + canReach);
		}
	}
}