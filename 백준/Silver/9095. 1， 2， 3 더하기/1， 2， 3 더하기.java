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
        int arr[] = new int[11];
		int testNum, i;
        
        //입력
        testNum =Integer.parseInt(br.readLine());
        int num[] = new int[testNum];
        for (i = 0; i < testNum; i++)
        	num[i] = Integer.parseInt(br.readLine());
        
        for (i = 0; i < testNum; i++)
        {
            get_Sum(num[i], arr);
            System.out.println(sum);
            sum = 0;
        }

    }
    public static void get_Sum(int num, int[] arr)
    {
    	int i;
    	int[] array = {1, 2, 3};
    	
		//다했으면 탈출
		if (num == 0)
			sum++;

		
    	//재귀로 하나씩
    	for (i = 0; i < 3; i++)
    	{
    		//뺄 수가 더 커지면 나가기
    		if (num < array[i])
    			break;
    		
    		//System.out.printf(array[i] + " ");
    		get_Sum(num-array[i], arr);
    	}
    }
}