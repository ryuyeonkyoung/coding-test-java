import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0)
                if (minQueue.isEmpty())
                    sb.append("0").append("\n");
                else
                    sb.append(minQueue.poll()).append("\n");
            else minQueue.add(n);
        }

        System.out.println(sb);

    }
}