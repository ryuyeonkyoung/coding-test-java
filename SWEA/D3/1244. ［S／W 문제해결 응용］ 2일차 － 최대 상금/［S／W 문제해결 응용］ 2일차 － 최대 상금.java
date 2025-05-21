
import java.util.Scanner;

//1244. [S/W 문제해결 응용] 2일차 - 최대 상금
public class Solution {
	static int switchNum;
	static char[] arr;
	static int max = 0;

	public static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int charArrToInt() {
		return Integer.parseInt(new String(arr));
	}

	public static void dfs(int start, int dept) {
		if (dept > switchNum) return;
		if (dept == switchNum) {
			int result = charArrToInt();
			max = Math.max(result, max);
		}

		for (int i=start; i<arr.length; i++) {
			for (int j=i+1;j<arr.length; j++) {
				if (arr[i] == arr[j]) continue;
				swap(arr, i, j);
				dfs(i, dept+1);
				swap(arr, i, j);
			}
		}
	}

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/1244_input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 반복 횟수
		for (int test_case = 1; test_case <= T; test_case++) {
			max = 0;

			// 입력
			String input = sc.next();
			switchNum = sc.nextInt();

			arr = input.toCharArray();

			dfs(0,0);

			System.out.println("#" + test_case + " " + max);
		}
	}
}