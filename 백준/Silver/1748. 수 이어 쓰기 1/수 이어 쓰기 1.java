import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.io.IOException;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num, i, digit=0;
        
        //입력
        num= Integer.parseInt(br.readLine());
        
        //계산 및 출력
        System.out.println(digit_sum(num));
    }
    
    public static int digit(int num)
    {
    	return (int)( Math.log10(num)+1 );
    }
    public static int digit_sum(int num)
    {
    	int digit, i, j=1, sum=0;
    	digit = digit(num);
    	
    	//digit*n-10-100...+(digit-1)
    	for(i = 0; i < digit-1; i++)
    	{
    		j*=10;
    		sum-=j;
    	}
    	sum+=digit-1;
    	
    	return digit*num+sum;
    }
}