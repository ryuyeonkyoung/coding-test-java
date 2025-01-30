import java.util.*;

// 1. 해시에 종류별로 포켓몬 정리하기
// 2. 가장 많이 선택할 수 있는 종류 번호의 개수 리턴..? (최댓값 n/2, 이외에는 key의 개수)
class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> ponkets = new HashMap<>();
        
        for (int n : nums) {
            // key가 있으면 value+1
            // key가 없으면 key,value 생성
            if (ponkets.containsKey(n))
                ponkets.put(n, ponkets.get(n) + 1);
            else
                ponkets.put(n, 1);
        }
        
        if (ponkets.size() > nums.length/2)
            return nums.length/2;
        else return ponkets.size();
    }
    
    
}