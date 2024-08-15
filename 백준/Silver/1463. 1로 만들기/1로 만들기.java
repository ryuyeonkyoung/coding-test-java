import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int  min;
    public static void counting (int n, int cnt) {
        if (cnt >= min)
            return;
        if (n == 1) {
            if (cnt < min)
                min = cnt;
            return;
        }
        if (n % 3 == 0){
            counting(n/3, cnt+1);
        }
        if (n % 2 == 0) {
            counting(n/2, cnt+1);
        }
        counting(n-1, cnt+1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        min = N;
        counting(N,0);
        System.out.println(min);

    }
}