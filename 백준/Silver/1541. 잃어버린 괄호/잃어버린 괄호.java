import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "+-", true);
        boolean minusflag = false;
        int sum = 0;

        sum += Integer.parseInt(st.nextToken());
        while (st.hasMoreTokens()) {
            String cal = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            if (!minusflag && cal.equals("-"))
                minusflag = true;
            if (minusflag)
                sum -= n;
            else sum += n;
        }

        System.out.println(sum);

    }
}