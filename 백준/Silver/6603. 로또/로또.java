import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.io.IOException;
import java.util.Arrays;

public class Main{
	//전역변수
    static int sum = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
    	int[] pick = new int[6];
        int[][] arr = new int[10000][100];
        //숫자 입력
        int i=0, j=0;
        
        while(true)
        {
            //입력 및 첫번째 숫자 뽑기
        	String[] strs = br.readLine().split(" ");
        	if (Integer.parseInt(strs[0]) == 0) // 0입력하면 나가기
        		break;
        	for (j = 0; j <= Integer.parseInt(strs[0]); j++)
            	arr[i][j] = Integer.parseInt(strs[j]);
            i++;
        }
        
        i=0;
        while(true)
        {
        	if (arr[i][0] == 0)
        		break;
            //printArr(arr);
            combination(arr, pick, 6, 1, arr[i][0], i);
            System.out.println("");
            i++;
        }
        
    }
    static void combination(int[][] arr, int[] pick, int n, int c, int num, int in)
    {
    	//6개 다 뽑은 경우(pick = 5)
    	if (n == 0)
    	{
    		printArr(pick);
    		return;
    	}
    	//c가 끝까지 왔을 때
    	if (c == num)
    	{
    		//pick도 마지막일 때
    		if (n == 1)
    		{
    			pick[5] = arr[in][c];
    			printArr(pick);
    			return;
    		}
    		//pick이 덜채워졌을 때
    		else
    			return;
    	}
    	
    	//arr[c]를 뽑은 경우
        pick[6-n] = arr[in][c];
        combination(arr, pick, n-1, c+1, num, in);
        //arr[c]를 안뽑은 경우
        combination(arr, pick, n, c+1, num, in);
    	
    	
    }
    public static void printArr(int[] arr)
    {
    	int i;
    	
    	for (i = 0; i < 6; i++)
    		System.out.printf(arr[i] + " ");
    	System.out.println("");
    }
}