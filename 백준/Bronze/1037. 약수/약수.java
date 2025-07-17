import java.util.Arrays;
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int i, num;
        
        num = sc.nextInt();
        int[] arr = new int[num];
        
        for (i = 0; i < num; i++)
        	arr[i]=sc.nextInt();
        
        Arrays.sort(arr);
        System.out.println(cal(arr, num));
        sc.close();
        
	}
	
	static int cal(int a[], int n)
	{
		if (n == 1)
			return a[0] * a[0];
		return a[0] * a[n - 1];
	}
}