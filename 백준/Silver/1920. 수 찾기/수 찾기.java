import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static boolean binary_search(int[] arr, int n){
        int lo=0;
        int hi=arr.length-1;
        int mid;

        while(lo <= hi) {
            mid = (lo+hi)/2;
            if(arr[mid] == n)
                return true;
            else if (arr[mid] < n) lo=mid+1;
            else if (n < arr[mid]) hi = mid-1;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt((st.nextToken()));
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt((st.nextToken()));
            if (binary_search(arr, n))
                System.out.println("1");
            else
                System.out.println("0");
        }
        bw.flush();
        bw.close();
    }
}