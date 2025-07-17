import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int sum = 0;

        Stack<Integer> s = new Stack<>();

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            n = Integer.parseInt(br.readLine());
            if (n == 0)
                s.pop();
            else s.push(n);
        }

        int size= s.size();
        if (size != 0) {
            for (int i = 0; i < size ; i++) {
                sum += s.pop();
            }
        }

        System.out.println(sum);
    }
}