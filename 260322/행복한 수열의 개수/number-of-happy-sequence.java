import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int happyCnt = 0;
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        happyCnt = getHappyCnt(grid, n, m);
        System.out.println(happyCnt);
    }

    public static int getHappyCnt(int[][] grid, int n, int m) {
        HashMap<Integer, Integer> rowMap = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> colMap = new HashMap<Integer, Integer>();
        int currNum, mCnt;
        int happyCnt = 0;

        // 한 줄만 전역변수 배열에 담아서 실행할 수 있음
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            currNum = 0;
            mCnt = 1;
            for (int j = 0; j < n; j++) {
                if (currNum == grid[i][j]) {
                    mCnt++;
                } else {
                    if (mCnt >= m) flag = true; // maxCnt를 따로 만들어두면 마지막에만 판단해도 됨
                    currNum = grid[i][j];
                    mCnt = 1;
                }
            }
            if (mCnt >= m) flag = true;
            if (flag) happyCnt++;
        }

        for (int i = 0; i < n; i++) {
            boolean flag = false;
            currNum = 0;
            mCnt = 1;
            for (int j = 0; j < n; j++) {
                if (currNum == grid[j][i]) {
                    mCnt++;
                } else {
                    if (mCnt >= m) flag = true;
                    currNum = grid[j][i];
                    mCnt = 1;
                }
            }
            if (mCnt >= m) flag = true;
            if (flag) happyCnt++;
        }

        return happyCnt;
    }
}