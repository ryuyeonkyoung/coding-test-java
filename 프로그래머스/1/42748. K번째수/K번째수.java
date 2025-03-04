import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int i, j, k, index = 0;
        
        for (int[] row : commands) {
            i = row[0];
            j = row[1];
            k = row[2];
            
            int[] copyArray = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(copyArray);
            answer[index++] = copyArray[k - 1];
        }
        
        return answer;
    }
}