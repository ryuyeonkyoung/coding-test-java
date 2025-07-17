import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[42];
        int N;

        arr[0] = 1;
        arr[1] = 0;
        for (int i = 2; i < 42; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            sb.append(arr[N]).append(" ");
            sb.append(arr[N+1]).append("\n");
        }

        System.out.println(sb);

    }
}