import java.util.*;

// 1. 해시에 종류별로 포켓몬 정리하기
// 2. 가장 많이 선택할 수 있는 종류 번호의 개수 반환 (최댓값 n/2, 이외에는 key의 개수)
class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> ponkets = new HashMap<>();
        
        for (int n : nums) {
            // value의 개수를 셀 필요가 없으니 덮어씌워도 된다.
            ponkets.put(n, 1);
        }
        
        // if문을 삼항연산자로
        return ponkets.size() > nums.length / 2 ? nums.length / 2 : ponkets.size();
    }
    
    
}