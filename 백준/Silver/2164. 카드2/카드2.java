import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        var N = sc.nextInt();
        int n = N;

        for (int i =1; i <= N; i++)
            queue.add(i);

        while(queue.size() != 1) {
            queue.remove();
            queue.add(queue.poll());
        }
        System.out.println(queue.peek());
    }
}