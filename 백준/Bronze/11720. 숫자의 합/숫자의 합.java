import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int i, sum = 0;

        for(i = 0; i < N; i++)
            sum += str.charAt(i) - 48;

        System.out.println(sum);

    }
}