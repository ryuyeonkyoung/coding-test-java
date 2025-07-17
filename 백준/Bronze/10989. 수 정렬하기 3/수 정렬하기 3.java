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
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        int i;

        for (i = 0; i < N; i++)
            num[i] = Integer.parseInt(br.readLine());

        //오름차순 정렬
        Arrays.sort(num);
        //출력
        for (Integer n : num)
            sb.append(n).append("\n");
        System.out.println(sb);
    }
}