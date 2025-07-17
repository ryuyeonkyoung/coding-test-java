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
        int N2 = N-1;
        long i, num=1;

        //2 이하
        for (i = 0; i < 3; i++)
        {
            if (1 <N && N <= 7)
            {
                num = 2;
                break;
            }
        }
        //3이상
        for (i = 3; i < 20000; i++)
        {
            if ( 3*(i-2)*(i-1) < N2 && N2 <= 3*(i-1)*i )
            {
                num = i;
                break;
            }
        }

        System.out.println(num);
    }
}