import java.util.*;

class Solution {
    boolean solution(String s) {
        char[] charArr = s.toCharArray();
        // Deque<String> q = new ArrayDeque<>();
        int leftBrackNum = 0;

        // fastpath
        if (s.charAt(0) == ')') return false;
        if (s.charAt(s.length() - 1) == '(') return false;

        // 스택에 담기
        // 
        // 1. 하나를 꺼낸다
        // 2. 그 하나가 (이면 넣기
        // 3. 그 하나가 ) 이면 peek으로 (가 있는지 보기
            // 3-1. (가 없으면=)가 있거나 비어있으면 return false
            // 3-2. (가 있으면 터트린 후 지나가기
        
        // 모든 단계가 끝난 후 스택이 비어 있으면 true, 그렇지 않으면 false
        for(char c: charArr) {
            if (c == '(') {
                // q.push(String.valueOf(c));
                leftBrackNum++;
                continue;
            }
            
            if (leftBrackNum <= 0) return false;
            leftBrackNum--;
        }
        
        if (leftBrackNum > 0) return false;
        return true;
    }
}