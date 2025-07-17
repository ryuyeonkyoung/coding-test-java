import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int findNumOfCoin (int[] arr, int price) {
        int coinNum = 0;

        if (price == 0)
            return 0;

        for (int i = 0; i < arr.length; i++) {
            if (price >= arr[i]) {
                coinNum = price/arr[i];
                price -= coinNum * arr[i];
                break;
            }
        }
        return findNumOfCoin(arr, price) + coinNum;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Integer[] integerArr = new Integer[N];
        for (int i = 0; i < N; i++) {
            integerArr[i] = Integer.parseInt(br.readLine());
        }
        List<Integer> list = Arrays.asList(integerArr);
        Collections.sort(list, Comparator.reverseOrder());
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();

        System.out.println(findNumOfCoin(arr, K));
    }
}