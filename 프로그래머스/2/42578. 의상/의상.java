import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map <String, LinkedList<String>> clothesMap = new HashMap<String, LinkedList<String>>();

        for (String[] arr: clothes) {
            // System.out.println("arr[1]: " + arr[1]);
            // System.out.println("arr[0]: " + arr[0]);
            if (clothesMap.get(arr[1]) == null) {
                clothesMap.put(arr[1], new LinkedList<String>());
            }
            clothesMap.get(arr[1]).add(arr[0]);
        }

        int cnt = 1;
        for (LinkedList<String> list: clothesMap.values()) {
            // System.out.println(list.size());
            cnt *= list.size() + 1;
        }

        return cnt - 1;
    }
}