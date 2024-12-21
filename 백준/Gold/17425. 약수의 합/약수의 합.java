import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class Main{
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		final int n_Max = 1_000_000;
		int i, j, testNum, input;
        long[] sum = new long[n_Max+1];
        long[] sumSum = new long[n_Max+1];

        
        //1,000,000까지 sum 배열에다가 배수들 더해놓기
        Arrays.fill(sum, 1);
        for (i = 2 ; i <= n_Max; i++)
        	for(j = 1; i * j <= n_Max; j++)
        		sum[i * j] += i;
        
        //sumSum 채우기. 여기서 시간단축
		for (i = 1; i <= n_Max; i++)
			sumSum[i] += sumSum[i-1] + sum[i];
		
        //입력 및 출력
        testNum = Integer.parseInt(br.readLine());
        while(testNum-->0)
        	sb.append(sumSum[Integer.parseInt(br.readLine())] + "\n");
        System.out.println(sb);
	}
}
