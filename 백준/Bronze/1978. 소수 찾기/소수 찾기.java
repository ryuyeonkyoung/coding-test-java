import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i, j, num, count;
        int[] arr = new int[101];
        int[] prime = new int[1001];
        
        //문자들 입력
        num = Integer.parseInt(br.readLine());
        String[] strs = br.readLine().split(" ");
        for (i = 0; i < num; i++)
        	arr[i] = Integer.parseInt(strs[i]);
        
        //소수 1000까지 구하기(소수 아니면 0)
        for (i = 2; i <= 1000; i++)
        	prime[i] = 1;
        for (i = 2; i <= 32; i++)
        	for (j = 2; i*j <= 1000; j++)
        		prime[i*j]--;
        
        //소수랑 입력값 비교
        count = 0;
        for (i = 0; i < num; i++)
        {
        	if (prime[arr[i]] == 1)
        		count++;
        }
        
        System.out.println(count);
    }
}