import java.io.*;

public class Main {
    // 1. 0층일때 - k==0
    // 2. 1호일때 - 전층 1호와 동일
    // 3. (k, n-1) + (k-1, n)
    public static int numOfPeople(int k, int n) {
        if (k == 0)
            return n;
        else if (n == 1)
            return numOfPeople(k-1,1);
        else
            return numOfPeople(k,n-1) + numOfPeople(k-1,n);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            bw.write(Integer.toString(numOfPeople(k,n)));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}