import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static double count = 0;
    public static void divided (int size, int r, int c) {
        if (size == 1) {
            return;
        }

        if (r < size/2 && c < size/2) {
            divided(size/2,r,c);

        } else if (r < size/2 && c >= size/2) { // 2사분면
            count += Math.pow((double) size /2, 2);
            divided(size/2,r,c-size/2);
        } else if (r >= size/2 && c < size/2) { // 3사분면
            count += Math.pow((double) size /2, 2) * 2;
            divided(size/2,r-size/2,c);
        } else { // 4사분면
            count += Math.pow((double) size /2, 2) * 3;
            divided(size/2,r-size/2,c-size/2);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        divided((int)Math.pow(2,N), r,c);
        System.out.println((int)count);

    }
}