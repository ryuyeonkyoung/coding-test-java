class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int row = 0;
        int col = 0;
        
        for (int[] card : sizes) {
            // row - 긴 길이, col - 짧은 길이로 고정
            row = Math.max(row, Math.max(card[0], card[1]));
            col = Math.max(col, Math.min(card[0], card[1]));
        }
        
        // 긴 길의의 max값, 짧은 길이의 max값 곱하기
        answer = row * col;
        
        return answer;
    }
}