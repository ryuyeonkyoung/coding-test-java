import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int S = 0;

        int n;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "add":
                    n = Integer.parseInt(st.nextToken());
                    S |= (1 << n);
                    break;
                case "remove":
                    n = Integer.parseInt(st.nextToken());
                    S &= ~(1 << n); // 0000100 -> 1111011
                    break;
                case "check":
                    n = Integer.parseInt(st.nextToken());
                    sb.append((S & (1 << n)) != 0 ? 1 : 0).append("\n");
                    break;
                case "toggle":
                    n = Integer.parseInt(st.nextToken());
                    S ^= (1 << n);
                    break;
                case "all":
                    S = (1 << 21) - 1;
                    break;
                case "empty":
                    S = 0;
                    break;
            }
        }
        System.out.println(sb);
    }
}