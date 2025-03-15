import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        Integer[] IntegerArr = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(IntegerArr , Comparator.reverseOrder());
        
        for(int i = 0; i < IntegerArr.length; i++) {
            if (i + 1 > IntegerArr[i])
                return i;
        }
        return IntegerArr.length;
        
    }
}