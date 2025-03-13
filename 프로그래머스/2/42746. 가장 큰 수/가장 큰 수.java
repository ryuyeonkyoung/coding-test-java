import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] numToString = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            numToString[i] = numbers[i] + "";
        }

        Arrays.sort(numToString, (o1, o2) -> {
            return Integer.parseInt(o2 + o1) - Integer.parseInt(o1 + o2);
        });
        if (numToString[0].startsWith("0")) return "0"; // 모든 수가 0인 경우 고려
        
        
        for(String numStr : numToString) {
            answer.append(numStr);
        }
        
        return answer.toString();
    }
}