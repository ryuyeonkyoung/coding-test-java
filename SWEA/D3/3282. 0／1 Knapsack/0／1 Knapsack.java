
import java.io.FileInputStream;
import java.util.Scanner;

//5215. 햄버거 다이어트
public class Solution {

	public static int[][] dp;
	public static int[] V;
	public static int[] C;
	public static int N;
	public static int K;

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/3282_input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {

			// 입력
			N = sc.nextInt();
			K = sc.nextInt();
			V = new int[N+1];
			C = new int[N+1];
			dp = new int[N+1][K+1];

			for(int i=1; i<=N; i++) {
				V[i] = sc.nextInt();
				C[i] = sc.nextInt();
			}

			// DP
			for(int i=1; i<=N; i++) {
				for(int j=0; j<=K; j++) {
					if (j == 0) dp[i][j] = 0;
					if (j < V[i]) {
						dp[i][j] = dp[i-1][j];
					} else {
						dp[i][j] = Math.max(dp[i-1][j-V[i]] + C[i], dp[i-1][j]);
					}
				}
			}


			// 출력
			System.out.println("#" + test_case + " " + dp[N][K]);
		}
	}
}