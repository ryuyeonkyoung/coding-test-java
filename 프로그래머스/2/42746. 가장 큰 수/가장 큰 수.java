import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] numToString = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            numToString[i] = numbers[i] + "";
        }

        Arrays.sort(numToString, (o1, o2) -> {
            // o1 + o2는 Integer.MAX_VALUE(2,147,483,647)를 초과할 가능성이 있으므로, compareTo를 사용하는 것이 안전함
            return (o2 + o1).compareTo(o1 + o2);
        });
        if (numToString[0].startsWith("0")) return "0"; // 모든 수가 0인 경우 고려
        
        
        for(String numStr : numToString) {
            answer.append(numStr);
        }
        
        return answer.toString();
    }
}