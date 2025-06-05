import java.io.*;

public class Main {

    public static int aToz = 'Z'-'A'+1;
    public static int[] cntArr = new int[aToz];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String mostUsedAlpabet = null;
        int max = 0;
        int cntMaxAlpabet = 0;
        int index;

        String word = br.readLine();

        for (int i = 0; i < word.length(); i++) {
            // 대문자로 통일
            if (Character.isLowerCase(word.charAt(i))) {
                index = Character.toUpperCase(word.charAt(i))-'A';
            }
            else index = word.charAt(i)-'A';

            cntArr[index]++;
        }

        // max 값 구하기
        for (int i = 0; i < aToz; i++) {
            max = Math.max(max,cntArr[i]);
        }

        // 알파벳이 여러개인지 확인
        for (int i = 0; i < aToz; i++) {
            if (cntArr[i] == max) {
                cntMaxAlpabet ++;
            }
        }

        // 출력
        for (int i = 0; i < aToz; i++) {
            String currAlpha = Character.toString(i + 'A');

            // 가장 많이 입력된 알파벳 저장
            if (cntArr[i] == max)
                mostUsedAlpabet = currAlpha;
        }

        if (cntMaxAlpabet > 1)
            bw.write("?");
        else bw.write(mostUsedAlpabet);

        bw.flush();

    }
}