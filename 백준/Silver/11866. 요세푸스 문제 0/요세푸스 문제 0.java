import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        //StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        int i, a;

        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (i = 1; i <= N; i++)
            q.offer(i);

        for (i = 1; !q.isEmpty(); i++)
        {
            a = q.poll();
            if ( i % K != 0)
                q.offer(a);
            else
                q2.offer(a);
        }

        System.out.printf("<" + q2.poll());
        for (i = 0; i < N - 1; i++)
            System.out.printf(", " + q2.poll());
        System.out.printf(">");
    }
}