
import java.io.FileInputStream;
import java.util.Scanner;

//5215. 햄버거 다이어트
public class Solution {

	public static int[] scores;
	public static int[] calories;
	public static boolean[] checked;
	public static int N;
	public static int L;
	public static int max = 0;

	public static void printCalories() {
		for(int i=0; i<N; i++) {
			if (checked[i]) System.out.println(calories[i]);
		}
	}

	public static int getTotalCalories() {
		int sum = 0;
		for(int i=0; i<N; i++) {
			if (checked[i]) sum += calories[i];
		}
		return sum;
	}

	public static int getTotalScore() {
		int sum = 0;
		for(int i=0; i<N; i++) {
			if (checked[i]) sum += scores[i];
		}
		return sum;
	}

	public static void dfs(int start) {
		if (getTotalCalories() > L) return;
		else {
			max = Math.max(max, getTotalScore());
		}

		for(int i=start; i<N; i++) {
			if (!checked[i]) {
				checked[i] = true;
				dfs(i+1);
				checked[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/5215_input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			max = 0;

			N = sc.nextInt();
			L = sc.nextInt();
			scores = new int[N];
			calories = new int[N];
			checked = new boolean[N];
			for(int i=0; i<N; i++) {
				scores[i] = sc.nextInt();
				calories[i] = sc.nextInt();
			}

			dfs(0);

			System.out.println("#" + test_case + " " + max);
		}
	}
}