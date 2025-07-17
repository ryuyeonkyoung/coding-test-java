import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int[] intArr = new int[5];
        int i, num = 0;

        //배열 int형 형변환
        for (i=0; i < arr.length; i++)
            intArr[i] = Integer.parseInt(arr[i]);

        for (i=0; i < intArr.length; i++)
            num += intArr[i] * intArr[i];

        System.out.println(num%10);

    }
}