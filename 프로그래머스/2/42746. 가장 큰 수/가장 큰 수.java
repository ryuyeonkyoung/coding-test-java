import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] numToString = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            numToString[i] = numbers[i] + "";
        }

        Arrays.sort(numToString, (o1, o2) -> {
            return Integer.parseInt(o2 + o1) - Integer.parseInt(o1 + o2);
        });
        
        for(String numStr : numToString) {
            answer += numStr;
        }
        
        if (answer.startsWith("0")) return "0"; // 모든 수가 0인 경우 고려
        else return answer;
    }
}