import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import static java.util.Arrays.*;

public class Main {
    static int factorial(int n){
        if (n == 0)
            return 1;
        else
            return n * factorial(n-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        int nCk = 1;
        nCk *= factorial(N)/factorial(N-K)/factorial(K);

        System.out.println(nCk);
    }
}