import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int[] N = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
        int i;
        int flag = 0;

        for (i = 0 ;i < str.length - 1; i++)
        {
            //mixed
            if ((N[i] < N[i+1] && flag == -1) || (N[i] > N[i+1] && flag == 1))
            {
                flag = 2;
                break;
            }

            if (N[i] < N[i+1])
                flag = 1;
            if (N[i] > N[i+1])
                flag = -1;
        }

        if (flag == 1)
            System.out.println("ascending");
        else if (flag == -1)
            System.out.println("descending");
        else
            System.out.println("mixed");

    }
}