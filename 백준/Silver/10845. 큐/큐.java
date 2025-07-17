import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> q = new LinkedList<>();
        String result = "";

        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++){
            String[] str = br.readLine().strip().split(" ");
            switch (str[0]) {
                case "push":
                    q.add(Integer.parseInt(str[1]));
                    break;
                case "pop":
                    bw.write(q.isEmpty() ? "-1\n" : q.poll() + "\n");
                    break;
                case "size":
                    bw.write(q.size() + "\n");
                    break;
                case "empty":
                    bw.write(q.isEmpty() ? "1\n" : "0\n");
                    break;
                case "front":
                    bw.write(q.isEmpty() ? "-1\n" : q.peek() + "\n");
                    break;
                case "back":
                    bw.write(q.isEmpty() ? "-1\n" : q.getLast() + "\n");
                    break;
            }
        }

        bw.flush();
        bw.close();
    }
}