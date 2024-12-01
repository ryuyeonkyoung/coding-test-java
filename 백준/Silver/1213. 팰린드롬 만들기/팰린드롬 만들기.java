import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.*;

public class Main {
    public static char[] palindromeResult;
    public static Map<Character, Integer> numOfChar;
    public static char oddChar;
    public static boolean canPalindrome () {
        int oddCount = 0;

        // 홀수개의 문자가 몇개인지
        for (Map.Entry<Character, Integer> entry : numOfChar.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                oddChar = entry.getKey();
                oddCount++;
            }
        }

        if (oddCount >= 2) return false;
        else return true;
    }
    public static void palindrome () {
        int evenIndex = 0;
        int middle = palindromeResult.length / 2;
        int i;

        for (Map.Entry<Character, Integer> entry : numOfChar.entrySet()) {
            // char이 홀수개 있으면 하나 빼서 가운데 배치
            if (entry.getValue() % 2 != 0) {
                palindromeResult[middle] = entry.getKey();
            }

            // 나머지는 반으로 나눠서 양쪽 끝에 배치
            for (i = 0; i < entry.getValue() / 2; i++) {
                palindromeResult[evenIndex] = entry.getKey();
                palindromeResult[palindromeResult.length - 1 - evenIndex] = entry.getKey();
                evenIndex++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력
        char[] sortedChars = br.readLine().toCharArray();
        Arrays.sort(sortedChars);

        palindromeResult = new char[sortedChars.length];

        // HashMap으로 각 문자의 개수 세기
        numOfChar = new TreeMap<>();
        for (char ch:sortedChars) {
            if (numOfChar.containsKey(ch))
                numOfChar.put(ch, numOfChar.get(ch) + 1);
            else numOfChar.put(ch, 1);
        }

        // 안되는 경우 : 홀수개는 하나, 나머지는 짝수개가 아닐 때
        if (canPalindrome()) {
            palindrome();
            for (char ch : palindromeResult) {
                sb.append(ch);
            }
        }
        else sb.append("I'm Sorry Hansoo");

        System.out.println(sb.toString());
    }
}