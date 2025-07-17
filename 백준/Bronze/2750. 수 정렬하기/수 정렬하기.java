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
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> num = new ArrayList<Integer>();
        int i;

        for (i = 0; i < N; i++)
            num.add(Integer.parseInt(br.readLine()));

        //오름차순 정렬
        Collections.sort(num);
        //출력
        for (i = 0; i < N; i++)
            System.out.println(num.get(i));
    }
}