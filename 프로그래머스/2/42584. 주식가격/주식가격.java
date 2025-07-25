class Solution {
    public int[] solution(int[] prices) {
        int length = prices.length;
        int[] answer = new int[length];
        
        // O(n^2)
        // flag 및 if-else 문 필요 없음
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < length; j++) {
                answer[i]++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
        }
        
        return answer;
    }
}