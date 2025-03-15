import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        
        // int배열은 Comparator로 내림차순을 할 수가 없다. 따라서 Integer배열로 바꿔서 진행.
        Integer[] IntegerArr = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(IntegerArr , Comparator.reverseOrder());
        
        /* 
            6 5 3 1 0 : 내림차순한 배열
            0 1 2 3 4 : index(i)
            1 2 3 4 5 : index(i) + 1
            i+1 <= arr[i]일 때, H-Index의 후보군이 될 수 있다. 그중 가장 큰 수를 찾는 것이므로,
            i+1<=arr[i]를 만족하지 않는 순간을 찾아서 이전의 i를 return하면 된다 (i+1 - 1 = i)
            만약 마지막 수까지 H-Index의 후보군이 될 수 있다면, h는 n이다.
        */
        for(int i = 0; i < n; i++) {
            if (i + 1 > IntegerArr[i])
                return i;
        }
        return n;
        
    }
}