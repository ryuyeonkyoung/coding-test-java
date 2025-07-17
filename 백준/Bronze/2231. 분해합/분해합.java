import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int digit = (int)( Math.log10(N)+1 );
        int n, sum, Num = 0;

        //생성자 찾기. 찾으면 break;
        for (int i = N-digit*9; i < N; i++)
        {
            n = i;
            sum = n;

            //자릿수 더해서 나오면 break;
            while(n > 0){
                sum += n%10;
                n/=10;
            }
            if (sum == N)
            {
                Num = i;
                break;
            }
        }

        System.out.println(Num);
    }
}