import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.io.IOException;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i, j, noDwarf1 = 0, noDwarf2=0, sum = 0;
        int[] nine_tall = new int[9];
        int[] seven_tall = new int[7];
        
        //난쟁이 입력
        for (i = 0; i < 9; i++)
        {
        	nine_tall[i]= Integer.parseInt(br.readLine());
        	sum += nine_tall[i];
        }
        
        //7난쟁이 추리기
        for (i = 0; i < 9; i++)
        {
        	for (j = i+1; j < 9; j++)
        	{
        		if (sum-(nine_tall[i]+nine_tall[j])==100)
        		{
        			noDwarf1=i;
        			noDwarf2=j;
        		}
        	}
        }
        
        j=0;
        for (i = 0; i < 9; i++)
        	if ((i != noDwarf1) && (i != noDwarf2))
        			seven_tall[j++]=nine_tall[i];
        
        Arrays.sort(seven_tall);
        
        //7난쟁이 출력
        for (i = 0; i < 7; i++)
        	System.out.println(seven_tall[i]);
        
    }
}