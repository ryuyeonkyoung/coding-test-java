import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] maxDP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        maxDP = new int[N+1];

        arr[0] = 0;
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        maxDP[0] = 0;
        maxDP[1] = arr[1];
        if (N >= 2)
            maxDP[2] = arr[2] + arr[1];
        if (N >= 3) {
            for (int i = 3; i <= N; i++)
                maxDP[i] = Math.max(arr[i] + arr[i-1] + maxDP[i-3], arr[i] + maxDP[i-2]);
        }

        System.out.println(maxDP[N]);
    }
}