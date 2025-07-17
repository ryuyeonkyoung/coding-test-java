import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> tf = new ArrayList<>();
        int a,b,c;

        while(true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a==0 && b==0 && c==0)
                break;

            if ((a*a + b*b == c*c) || (a*a + c*c == b*b) || (c*c + b*b == a*a))
                tf.add("right");
            else tf.add("wrong");
        }

        for (int i = 0; i < tf.size(); i++ )
            System.out.println(tf.get(i));
    }
}