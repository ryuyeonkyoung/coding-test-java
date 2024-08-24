import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int n;
    public static int m;
    public static int[] dp;

    public static int solving () {
        // 1개씩
        for (int i = 1; i <= m; i++)
            if (i*i == n)
                return 1;

        // 2개씩
        for (int i = 1; i <= m ; i++)
            for (int j = 1; j <= m; j++)
                if (i*i + j*j == n)
                    return 2;

        // 3개씩
        for (int i = 1; i <= m ; i++)
            for (int j = 1; j <= m; j++)
                for (int k = 1; k <= m ; k++)
                    if (i*i + j*j + k*k == n)
                        return 3;

        return 4;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = (int)Math.sqrt(n);
        dp = new int[4*n + 1];
        for (int i = 1; i <= n; i++)
            dp[i] = 0;


        System.out.println(solving());
    }
}