import java.io.*;
import java.util.*;

public class Main {
    public static String[] digitStringArrs = new String[100000];
    public static String digitString;
    /*
        30의 배수의 조건1 : 10으로 나눴을 때 나머지가 0
        30의 배수의 조건2 : 3의 배수 : 숫자들의 합이 3의 배수
    */
    public static boolean isMultipleOf30 () {
        boolean containsZero = false;
        int sum = 0;
        // 함수 안에 0이 없으면 false
        // 함수의 합이 3의 배수여야 함
        for (String s : digitStringArrs) {
            int a = Integer.parseInt(s);
            if (a == 0) containsZero = true;
            sum += a;
        }

        if (containsZero && sum % 3 == 0) return true;
        else return false;
    }

    public static String makeMultipleOf30 () {
        String numString = "";
        Arrays.sort(digitStringArrs, Collections.reverseOrder());
        for (String s: digitStringArrs) {
            numString += s;
        }

        return numString;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력
        digitString = br.readLine();
        digitStringArrs = digitString.split("");

        if (isMultipleOf30()) {
            bw.write(makeMultipleOf30());
        } else bw.write("-1");

        
        bw.flush();

    }

}