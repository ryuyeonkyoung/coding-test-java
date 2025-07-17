import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import static java.util.Arrays.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] N;
        int i;

        Loop1 :
        while (true) { //0이 입력될 때까지 문자열 N 입력
            N = br.readLine().split("");

            if (N[0].equals("0"))
                break;

            for (i = 0; i < N.length; i++) {
                if (!N[N.length - 1 - i].equals(N[i])){
                    sb.append("no\n");
                    continue Loop1;
                }
            }
            sb.append("yes\n");
        }

        System.out.println(sb);
    }
}