import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().trim().split(" ");

        if (str.length == 1 && str[0].equals(""))
            System.out.println("0");
        else System.out.println(str.length);
    }
}