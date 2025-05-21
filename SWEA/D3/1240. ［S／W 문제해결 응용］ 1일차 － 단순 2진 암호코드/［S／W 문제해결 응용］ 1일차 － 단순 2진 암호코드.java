import java.io.FileInputStream;
import java.util.Scanner;

// 1240. [S/W 문제해결 응용] 1일차 - 단순 2진 암호코드
public class Solution {

	static int codeLength = 7;
	static int codeNum = 8;
	static String[] stringCodes = new String[codeNum];
	static int[] intCodes = new int[codeNum];

	public static int getCodeNum(String s) {
		if (s.equals("0001101")) return 0;
		else if (s.equals("0011001")) return 1;
		else if (s.equals("0010011")) return 2;
		else if (s.equals("0111101")) return 3;
		else if (s.equals("0100011")) return 4;
		else if (s.equals("0110001")) return 5;
		else if (s.equals("0101111")) return 6;
		else if (s.equals("0111011")) return 7;
		else if (s.equals("0110111")) return 8;
		else if (s.equals("0001011")) return 9;
		else  return -10000000;
	}

	public static void convertStringCodesToIntCodes() {
		for(int i=0; i<codeNum; i++) {
			intCodes[i] = getCodeNum(stringCodes[i]);
		}
	}

	public static boolean isItRealCode() {
		int sumOfOdds = 0;
		int sumOfNotOdds = 0;
		int sum = 0;
		for(int i=0; i<codeNum; i++) {
			if ((i+1)%2 != 0) sumOfOdds += intCodes[i];
			else sumOfNotOdds += intCodes[i];
		}
		sum = sumOfOdds * 3 + sumOfNotOdds;

		if (sum % 10 == 0) return true;
		else return false;
	}

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/1240_input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {

			// 입력
			int N = sc.nextInt();
			int M = sc.nextInt();
			boolean saveCode = false;
			for(int i=0; i<N; i++) {

				String s = sc.next();
				for(int j=M-1; j>=0; j--) {
					if (saveCode) continue; // 코드 저장했으면 건너뛰기

					if (s.charAt(j) == '1') {
						int index = codeNum - 1;
						for(int k=0; k<codeNum; k++) {
							int leftIndex = j - codeLength*(k+1) + 1;
							int rightIndex = j - codeLength*k + 1;
							stringCodes[index--] = s.substring(leftIndex, rightIndex); // 코드 저장
						}
						saveCode = true;
					}
				}



			}

			// 코드 변환
			convertStringCodesToIntCodes();

			// 코드 진위여부 확인 및 출력
			int sum = 0;
			if (isItRealCode()) {
				for(int i=0; i<8; i++) {
					sum += intCodes[i];
				}
			}

			System.out.println("#" + test_case + " " + sum);
		}
	}
}