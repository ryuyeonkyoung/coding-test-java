
import java.io.FileInputStream;
import java.util.Scanner;

//1215. [S/W 문제해결 기본] 3일차 - 회문1
public class Solution {

	// 방향 벡터 (각각 오른쪽 방향과 아래 방향, 한 방향만 확인)
	static int[] dx = {1,0};
	static int[] dy = {0,1};
	static char[][] board = new char[8][8];
	static int palindromeNum = 0;
	static int palinLeng;

	// 시작점과 방향값을 넘겨주면, 길이를 더해 경계를 넘는지 확인
	public static boolean isNotOutOfBoundary(int y, int x, int dir) {
		int nx = x + dx[dir]*(palinLeng-1);
		int ny = y + dy[dir]*(palinLeng-1);
		return nx < 8 && ny < 8;
	}

	// 시작점과 방향값을 넘겨주면, palindrome인지 확인
	public static boolean isPalindrome(int y, int x, int dir) {
		for (int i=0; i<palinLeng/2; i++) {
			int x1 = x + dx[dir]*i;
			int y1 = y + dy[dir]*i;
			int x2 = x + dx[dir]*(palinLeng-i-1);
			int y2 = y + dy[dir]*(palinLeng-i-1);
			if (board[y1][x1] != board[y2][x2]) return false;
		}

//		for (int i=0; i<palinLeng; i++) {
//			System.out.print(board[y + dy[dir]*i][x + dx[dir]*i]);
//		}
//		System.out.println();
		return true;
	}

	// 시작점과 방향값을 넘겨주면, 확인 후 맞으면 sum++
	public static void findPalindrome() {
		for (int y=0; y<8; y++) {
			for (int x=0; x<8; x++) {
				for (int i=0; i<2; i++) {
					if (isNotOutOfBoundary(y, x, i))
						if (isPalindrome(y, x, i))
							palindromeNum++;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/1215_input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			palindromeNum = 0;

			// 입력
			palinLeng = sc.nextInt();
			for(int i=0; i<8; i++) {
				String s = sc.next();
				board[i] = s.toCharArray();
			}

			// palindrome 찾기
			findPalindrome();

			// 출력
			System.out.println("#" + test_case + " " + palindromeNum);
		}
	}
}