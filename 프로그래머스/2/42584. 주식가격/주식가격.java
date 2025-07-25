class Solution {
    public int[] solution(int[] prices) {
        int length = prices.length;
        int[] answer = new int[length];

        for (int i = 0; i < prices.length; i++) {
            // 중간에 더 작은 수가 나타나면 길이 측정
            boolean flag = false;
            for (int j = i + 1; j < prices.length; j++) {
                // System.out.println("i:" + i + "j:" + j);
                if (prices[i] > prices[j]) {
                    flag = true;
                    answer[i] = j - i;
                    break;
                }
            }
            // 마지막까지 작은 수가 없다면 마지막까지의 길이 측정
            if (!flag) {
                answer[i] = prices.length - 1 - i;
            }
        }

        return answer;
    }
}