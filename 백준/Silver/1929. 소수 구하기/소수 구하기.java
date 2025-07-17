import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i, j, m, n;
        int[] prime = new int[1000001];
        
        //m, n 입력
        String[] strs = br.readLine().split(" ");
        m = Integer.parseInt(strs[0]);
        n = Integer.parseInt(strs[1]);
        
        //소수 1,000,000까지 구하기(소수 아니면 0)
        for (i = 2; i <= 1000000; i++)
        	prime[i] = 1;
        for (i = 2; i <= 1000; i++)
        	for (j = 2; i*j <= 1000000; j++)
        		prime[i*j]--;
        
        //소수 출력
        for (i = m; i <= n; i++)
        	if (prime[i] == 1)
        		System.out.println(i);
    }
}