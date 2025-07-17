import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int countTwos(int N){
        int cnt = 0;
        int multiple = 1;

        do{
            multiple *= 2;
            cnt += N/multiple;
        } while (N >= multiple);

        return cnt;
    }
    public static int countFives(int N){
        int cnt = 0;
        int multiple = 1;

        do{
            multiple *= 5;
            cnt += N/multiple;
        } while (N >= multiple);

        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().strip());
        System.out.println(Math.min(countTwos(N), countFives(N)));
    }
}