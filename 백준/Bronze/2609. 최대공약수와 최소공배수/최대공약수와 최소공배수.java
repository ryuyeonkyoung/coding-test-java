import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
        int a = Integer.parseInt(strs[0]);
        int b = Integer.parseInt(strs[1]);
        System.out.println(gcd(a, b));
        System.out.println(lcm(a, b));

	}
    public static int gcd(int a, int b)//최대공약수
    {
        while( a%b != 0)
        {
            int r = a%b;
            a = b;
            b = r;
        }
        return b;
    }

    public static int lcm(int a, int b)//최소공배수
    {
        return a*b/gcd(a,b);
    }
}
