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
        int num, i;
        
        //숫자 입력
        num =Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        int[] nextArr=new int[num];
        //문자열 입력
        String[] strs = br.readLine().split(" ");
        for (i = 0; i < num; i++)
        	arr[i] = Integer.parseInt(strs[i]);
        
        //다음 순열 구하기
        nextArr=nextPermute(arr);
        
        //다음 순열 출력
        if (nextArr != null)
        	for (i = 0; i < num; i++)
        		System.out.print(nextArr[i] + " ");
        else
        	System.out.println("-1");
    }
    //다음 순열 찾기
    private static int[] nextPermute(int[] arr) {
    	int i, j = -1, index = -1, n=arr.length;
    	
    	//index찾기
    	for (i = 0; i < n-1; i++)
    		if (arr[i] < arr[i+1])
    			index=i;
    	if (index == -1)
    		return null;
    	//j 찾기
    	for (i = index; i < n; i++)
    		if (arr[index] < arr[i])
    			j=i;
    	
    	//swap a[index]<->a[j]
    	swap(arr, index, j);
    	//나머지들을 역순으로 배치
    	if (index < j)
    		Arrays.sort(arr, index+1, n);
    		
    	
    	return arr;
    }
    public static int[] swap(int[] arr, int a, int b)
    {
    	int temp = arr[a];
    	arr[a] = arr[b];
    	arr[b] = temp;
    	
    	return arr;
    }
}