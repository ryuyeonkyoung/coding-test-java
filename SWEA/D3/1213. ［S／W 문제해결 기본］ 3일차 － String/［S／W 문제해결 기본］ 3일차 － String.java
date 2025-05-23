
import java.util.Scanner;

//1213. [S/W 문제해결 기본] 3일차 - String
public class Solution {

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/1213_input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			sc.next();
			String search = sc.next().trim();
			String s = sc.next().trim();
			int cnt = 0;

			for (int i=0; i<= s.length()-search.length(); i++) {
				if (search.equals(s.substring(i, i + search.length()).trim())) {
					cnt++;
				}
			}

			System.out.println("#" + test_case + " " + cnt);
		}
	}
}