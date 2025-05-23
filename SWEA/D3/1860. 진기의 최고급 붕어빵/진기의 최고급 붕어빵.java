

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

//1860. 진기의 최고급 붕어빵
public class Solution {
    static int[] arrivedTime;
    static int[] dp;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("res/1860_input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int test_case=1; test_case<=T; test_case++) {

        	// 입력
        	int N = sc.nextInt(); // 손님 수
        	int M = sc.nextInt(); // 붕어빵 만드는 시간
        	int K = sc.nextInt(); // 한번에 만드는 붕어빵의 수
        	arrivedTime = new int[N+1];
        	for(int i=1; i<=N; i++) {
        		arrivedTime[i] = sc.nextInt();
        	}
        	Arrays.sort(arrivedTime);

        	// DP: 초 단위로 만들어진 붕어빵 개수 계산
        	int lastArrivedTime = 0;
    		for(int i=1; i<=N; i++) {
    			lastArrivedTime = Math.max(lastArrivedTime, arrivedTime[i]);
    		}
        	dp = new int[lastArrivedTime + 1];
			dp[0] = 0;
    		String isPossible = "Possible";
			int index = 1;
			if (arrivedTime[1] == 0) isPossible = "Impossible";
    		for(int i=1; i<=lastArrivedTime; i++) {
    			if (i % M == 0) dp[i] = dp[i-1] + K;
    			else dp[i] = dp[i-1];

    			// 손님이 왔으면 붕어빵 서빙
    			if (i == arrivedTime[index]) {
    				if (dp[i] < 1) {
    					isPossible = "Impossible";
        				break;
    				} else dp[i]--;
    				index++;
    			}
    		}


            System.out.println("#"+test_case+" "+isPossible);
        }
    }
}