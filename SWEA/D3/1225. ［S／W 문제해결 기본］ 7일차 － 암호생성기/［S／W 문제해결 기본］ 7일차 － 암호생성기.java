import java.io.FileInputStream;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

// 1225. [S/W 문제해결 기본] 7일차 - 암호생성기
public class Solution {

	static Deque<Integer> deque = new LinkedList<Integer>();
	static int dequeNum = 8;

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/1225_input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {

			// 입력
			sc.next();
			for(int i=0; i<dequeNum; i++) {
				deque.addLast(sc.nextInt());
			}

			// 암호 도출
			int deleteNum = 1;
			while(true) {
				if (deque.getFirst() > deleteNum) {
					deque.addLast(deque.removeFirst() - deleteNum);
				} else {
					deque.removeFirst();
					deque.addLast(0);
					break;
				}

				if (deleteNum == 5) deleteNum = 1;
				else deleteNum++;
			}

			System.out.print("#" + test_case + " ");
			while(deque.peekFirst() != null) {
				System.out.print(deque.removeFirst() + " ");
			}
			System.out.println();
		}
	}
}