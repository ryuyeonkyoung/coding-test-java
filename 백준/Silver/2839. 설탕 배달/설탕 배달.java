import java.io.*;

public class Main {
    public static int calculate(int n) {
        int five = n/5;

        if (n % 5 == 0)
            return n/5;
        while(five >= 0){
            if ((n - 5*five) % 3 == 0)
                return five + (n - 5*five) / 3;
            else
                five--;

        }
        return -1;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(calculate(N));

    }
}