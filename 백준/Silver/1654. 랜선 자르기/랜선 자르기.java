import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static long lsNum (int[] arr, int length) {
        long cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            cnt += arr[i] / length;
        }
        return cnt;
    }

    public static int binarySearch(int[] arr, int N) {
        int low = 1;
        int high = arr[0];
        for (int i : arr) {
            high = Math.max(high, i);
        }
        if (lsNum(arr, high) >= N)
            return high;

        while (low <= high) {
            int mid = low + (high - low)/2;
            long Num = lsNum(arr, mid);

//            System.out.println("low = "+low+", high = "+ high +", mid = " +mid);
//            System.out.println(Num);
//            System.out.println(lsNum(arr, mid+1));

            if (Num == N) {
                if (lsNum(arr, mid+1) == N)//N개로 잘리지만 더 크게 자를 수 있는 경우
                    low = mid + 1;
                else
                    return mid;
            } else if (Num > N) {
                if (lsNum(arr, mid+1) < N) //잘린 개수는 N보다 크지만 더 크게는 못 자를 경우
                    return mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int lan[] = new int[K];
        for (int i = 0; i < K; i++) {
            lan[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(binarySearch(lan, N));

    }
}