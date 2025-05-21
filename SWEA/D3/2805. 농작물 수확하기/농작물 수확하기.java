
import java.io.FileInputStream;
import java.util.Scanner;

//2805. 농작물 수확하기
public class Solution {

	static char[][] charFarm;
	static int N;

	public static int sumOfAllFarm() {
		int sum = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sum += charFarm[i][j] - '0';
			}
		}
		return sum;
	}

	public static int sumOfWhiteFarm() {
		int sum = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<Math.abs(N/2-i); j++) {
				// i=1 -> j<2 (N/2의 절댓값)
				// i=2 -> j<1 (N/2-1의 절댓값)
				// i=3 -> j<0 (N/2-2의 절댓값)
				// i=4 -> j<1 (N/2-3의 절댓값)
				// i=5 -> j<2 (N/2-4의 절댓값)
				sum += charFarm[i][j] - '0';
				sum += charFarm[i][N-1-j] - '0';
			}
		}
		return sum;
	}

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/2805_input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			N = sc.nextInt();
			charFarm = new char[N][N];
			for(int i=0; i<N; i++) {
				String s = sc.next();
				charFarm[i] = s.toCharArray();
			}

			int sumOfBlueFarm = sumOfAllFarm() - sumOfWhiteFarm();

			System.out.println("#" + test_case + " " + sumOfBlueFarm);
		}
	}
}