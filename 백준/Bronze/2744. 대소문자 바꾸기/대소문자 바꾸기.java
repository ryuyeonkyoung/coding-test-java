import java.util.*;           // List, Map, Set, Queue, Deque 등 대부분 자료구조
import java.io.*;             // BufferedReader, BufferedWriter
import java.util.StringTokenizer;  // 이건 따로! ⭐ 꼭 기억!

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());

        String word = st.nextToken();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'a' && c <= 'z') {
                // 소문자 -> 대문자
                bw.write((char) (c - 32));
            } else if (c >= 'A' && c <= 'Z') {
                // 대문자 -> 소문자
                bw.write((char) (c + 32));
            } else {
                // 알파벳이 아닌 경우 그대로 출력
                bw.write(c);
            }
        }

        bw.flush();

    }
}