import java.util.Scanner;

//1209. [S/W 문제해결 기본] 2일차 - Sum
class Solution {

	static int[][] arr = new int[100][100];
	static int max = 0;

	public static void setMaxOfRow() {
		int sum = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				sum += arr[i][j];
			}
			max = Math.max(max, sum);
			sum = 0;
		}
	}

	public static void setMaxOfCol() {
		int sum = 0;
		for(int j = 0; j < 100; j++) {
			for(int i = 0; i < 100; i++) {
				sum += arr[i][j];
			}
			max = Math.max(max, sum);
			sum = 0;
		}
	}

	public static void setMaxOfDiagLeftToRight() {
		int sum = 0;
		for(int i = 0; i < 100; i++) {
			int j = i;
			sum += arr[i][j];
		}
		max = Math.max(max, sum);
		sum = 0;
	}

	public static void setMaxOfDiagRightToLeft() {
		int sum = 0;
		for(int i = 0; i < 100; i++) {
			int j = 99 - i;
			sum += arr[i][j];
		}
		max = Math.max(max, sum);
		sum = 0;
	}

	public static void main(String args[]) throws Exception
	{
//		System.setIn(new FileInputStream("res/1209_input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			max = 0;

			sc.next();
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			setMaxOfRow();
			setMaxOfCol();
			setMaxOfDiagLeftToRight();
			setMaxOfDiagRightToLeft();

			System.out.println("#" + test_case + " " + max);

		}
	}
}