import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static boolean isDevilNum(int n) {
        int cnt = 0;
        while(n != 0){
            if (n%10 == 6)
                cnt++;
            else cnt = 0;
            n = n/10;

            if (cnt == 3)
                return true;
        }
        return false;
    }
    public static int findDevilNum(int N){
        int cnt = 0;
        int n = 1;

        while (cnt != N){
            if(isDevilNum(++n))
                cnt++;
        }
        return n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());

        System.out.println(findDevilNum(N));
    }
}