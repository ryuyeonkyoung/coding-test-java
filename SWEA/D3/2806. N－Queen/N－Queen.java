
import java.util.Scanner;

//2806. N-Queen
public class Solution {

	// 인덱스: x좌표, 값: y좌표
	static int[] board;
	// 인덱스: y좌표, 값: 해당 y좌표에 퀸이 배치되었는지 여부
	static boolean[] checkY;
	static int N;
	static int nQueenNum = 0;

	public static boolean canPlace(int x, int y) {
		for(int i=0; i<x; i++) {
			if (board[i] == y) return false;
			if (Math.abs(i-x) == Math.abs(board[i]-y)) return false;
		}
		return true;
	}

	// x좌표는 1씩 증가, y값을 겹치지 않게 저장한다.
	public static void dfs(int x) {
		if (x == N) {
			nQueenNum++;
			return;
		}

		for(int y=0; y<N; y++) {
			if (!checkY[y] && canPlace(x,y)) {
				checkY[y] = true;

				board[x] = y;
				dfs(x+1);

				checkY[y] = false;
			}
		}

	}

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/2806_input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			nQueenNum = 0;

			N = sc.nextInt();
			checkY = new boolean[N];
			board = new int[N];

			dfs(0);

			System.out.println("#" + test_case + " " + nQueenNum);
		}
	}
}