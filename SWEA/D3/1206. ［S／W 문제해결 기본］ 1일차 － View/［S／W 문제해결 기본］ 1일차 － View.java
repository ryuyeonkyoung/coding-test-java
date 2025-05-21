

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.math.*;
 
//1206. [S/W 문제해결 기본] 1일차 - View
public class Solution {
    static int[] building;
    
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("res/1206_input.txt"));
        Scanner sc = new Scanner(System.in);
        
        int T = 10;    // 반복 횟수
        for(int test_case=1; test_case<=T; test_case++) {
            // building 입력
            int N = sc.nextInt();
            building = new int[N];
            for(int j=0; j<N; j++) {
                building[j] = sc.nextInt();
            } 
            // 조망권 계산
            int sum = 0;
            for(int j=2; j<N-2;j++) {
                // building[j] - Max(앞뒤 두칸의 건물 높이)
                // 빌딩높이 > Max일 때만 조망권 존재
                int Max_left = Math.max(building[j-1], building[j+1]);
                int Max_right = Math.max(building[j-2], building[j+2]);
                int Max = Math.max(Max_left, Max_right);
                
                if (building[j] > Max) {
                    sum += building[j] - Max;
                }
            }
            
            System.out.println("#"+test_case+" "+sum);
            sum = 0;
        }
    }
}