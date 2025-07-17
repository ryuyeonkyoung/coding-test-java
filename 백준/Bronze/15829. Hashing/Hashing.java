import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static BigInteger makeHash(int[] arr) {
        BigInteger hash = BigInteger.valueOf(0);
        int M = 1234567891;
        BigInteger r = BigInteger.valueOf(31);
        // a의 아스키코드는 97
        for (int i = 0; i < arr.length; i++) {
            hash  = hash.add(r.pow(i).multiply(BigInteger.valueOf(arr[i])));
            hash = hash.remainder(BigInteger.valueOf(M));
        }
        return hash;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        char[] charArray = br.readLine().toCharArray();
        int[] intArray = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            intArray[i] = charArray[i] - 96;
        }

        System.out.println(makeHash(intArray));

    }

}