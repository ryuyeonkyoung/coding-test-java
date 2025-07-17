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
        //StringBuilder sb = new StringBuilder();
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int i, j, k, sum = 0;

        String[] str2 = br.readLine().trim().split(" ");
        int[] num = Arrays.stream(str2).mapToInt(Integer::parseInt).toArray();

        for (i = 0; i < num.length; i++)
            for (j = i+1; j < num.length; j++)
                for (k = j+1; k < num.length; k++)
                    if (num[i] + num[j] + num[k] <= M)
                        if (M - (num[i] + num[j] + num[k]) <= M - sum)
                            sum = num[i] + num[j] + num[k];

        System.out.println(sum);
    }
}