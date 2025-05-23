
import java.io.FileInputStream;
import java.util.Scanner;

//1289. 원재의 메모리 복구하기
public class Solution {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/1289_input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 반복 횟수
		for (int test_case = 1; test_case <= T; test_case++) {
            String data = sc.next();

			int cnt = 0;
            int prev = 0;
            for (int i = 0; i < data.length(); i++) {
                int cur = data.charAt(i) - '0';

                if (prev != cur) {
                    prev = cur;
                    cnt++;
                }
            }

            System.out.println("#" + test_case + " " + cnt);
		}
	}
}