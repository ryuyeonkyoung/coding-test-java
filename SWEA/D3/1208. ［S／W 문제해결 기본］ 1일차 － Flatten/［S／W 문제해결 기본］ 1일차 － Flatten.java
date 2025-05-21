import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

class Solution {

	static int[] boxes = new int[100];

	public static void dumping() {
		boxes[0] += 1;
		boxes[boxes.length - 1] -= 1;
	}

	public static void main(String args[]) throws Exception
	{
//		System.setIn(new FileInputStream("res/1208_input.txt"));
		Scanner sc = new Scanner(System.in);

		int T;
		T=10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 입력
			int dumpNum = sc.nextInt();
			for(int i=0; i<100; i++) {
				boxes[i] = sc.nextInt();
			}

			// 덤핑
			for(int i=0; i<dumpNum; i++) {
				Arrays.sort(boxes);
				dumping();
			}

			// 출력
			Arrays.sort(boxes);
			System.out.println("#" + test_case + " " + (boxes[boxes.length - 1] - boxes[0]));
		}
	}
}