import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = br.readLine().toCharArray();
        int[] arr = new int[26];
        int i;

        for (i=0; i < arr.length; i++)
            arr[i] = -1;

        for (i=0; i < ch.length; i++)
            if (arr[ch[i]-97] == -1)
                arr[ch[i]-97]= i;

        for (i=0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}