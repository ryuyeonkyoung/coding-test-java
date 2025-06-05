import java.io.*;

public class Main {

    public static int aToz = 'z'-'a'+1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String word1 = br.readLine();
        String word2 = br.readLine();

        int[] cntArr1 = new int[aToz];
        int[] cntArr2 = new int[aToz];

        int sum = 0;
        int index;

        // word1에 대해 cntArr1 작성하기
        for (int i = 0; i < word1.length(); i++) {
            index = word1.charAt(i) - 'a';
            cntArr1[index]++;
        }

        // word2에 대해 cntArr2 작성하기
        for (int i = 0; i < word2.length(); i++) {
            index = word2.charAt(i) - 'a';
            cntArr2[index]++;
        }

        // 두 배열의 차이 절댓값 더하기
        for (int i = 0; i < aToz; i++) {
            sum += Math.abs(cntArr1[i] - cntArr2[i]);
        }

        System.out.println(sum);

    }
}