import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input, search;
        String[] result;
        int beforeSplitCnt, afterSplitCnt;

        // split 메소드로 검색 결과에 해당하는 문자열들을 잘라낸 배얼을 만든다.
        input = br.readLine();
        search = br.readLine();
        result = input.split(search);

        // 사라진 문자열의 길이를 계산해 등장 횟수를 계산한다.
        beforeSplitCnt = input.length();
        afterSplitCnt = 0;
        for (String s : result) {
//            System.out.println(s);
            afterSplitCnt += s.length();
        }

//        System.out.println("beforeSplitCnt: " + beforeSplitCnt);
//        System.out.println("afterSplitCnt: " + afterSplitCnt);
//        System.out.println("search.length(): " + search.length());
        int cnt = (beforeSplitCnt - afterSplitCnt) / search.length();

        System.out.println(cnt);
    }
}