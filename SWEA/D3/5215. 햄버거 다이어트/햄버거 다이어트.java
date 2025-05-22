
import java.io.FileInputStream;
import java.util.Scanner;

//5215. 햄버거 다이어트
public class Solution {

	public static int[] scores;
	public static int[] calories;
	public static int[][] dp;
	public static int N;
	public static int L;


	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/5215_input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {

			// 입력
			N = sc.nextInt();
			L = sc.nextInt();
			scores = new int[N+1];
			calories = new int[N+1];
			dp = new int[N+1][L+1];
			for(int i=1; i<=N; i++) {
				scores[i] = sc.nextInt();
				calories[i] = sc.nextInt();
			}

			// dp[i][j] = value
			// i는 1번째 재료부터 i번째 재료까지 고려한 경우
			// j는 남은 칼로리
			// value는 최대 score
			// 재료를 하나씩 더해 나가면서, 모든 칼로리에 대한 최대 스코어를 갱신함.
			for(int i=1; i<=N; i++) {
				for(int remainKcal=1; remainKcal<=L; remainKcal++) {
					// 1. 재료를 더해도 최대 칼로리를 넘지 않는지 확인한다.
					if (remainKcal < calories[i]) {
						dp[i][remainKcal] = dp[i-1][remainKcal];
					} else {
						dp[i][remainKcal] = Math.max(dp[i-1][remainKcal-calories[i]] + scores[i], dp[i-1][remainKcal]);
					}
				}
			}


			// 출력
			System.out.println("#" + test_case + " " + dp[N][L]);
		}
	}
}