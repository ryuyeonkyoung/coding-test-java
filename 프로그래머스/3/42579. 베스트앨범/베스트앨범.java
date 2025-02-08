import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map <String, Integer> totalPlayPerGenre = new HashMap<>();
        Map <String, Map<Integer, Integer>> map = new HashMap<>(); // {장르:{고유번호, 재생수}}

        for (int i = 0; i < genres.length; i++) {
            if (!map.containsKey(genres[i]))
                map.put(genres[i], new HashMap<>());
            
            map.get(genres[i]).put(i, plays[i]);
            totalPlayPerGenre.put(genres[i], totalPlayPerGenre.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<Integer> answer = new LinkedList<>();
        
        // 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
        List <Map.Entry<String,Integer>> totalPlayList = new ArrayList<>(totalPlayPerGenre.entrySet());
        totalPlayList.sort((entry1, entry2) -> entry2.getValue() - entry1.getValue());
                
        for (Map.Entry<String,Integer> entry : totalPlayList) {
            String genre = entry.getKey();
            
            // 2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
            // 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
            List <Map.Entry<Integer,Integer>> mapList = new ArrayList<>(map.get(genre).entrySet());
            mapList.sort((entry1, entry2) -> {
                int compareValue = entry2.getValue().compareTo(entry1.getValue()); // 값 기준 내림차순
                if (compareValue == 0) {
                    return entry1.getKey().compareTo(entry2.getKey()); // 값이 같으면 key 기준 오름차순
                }
                return compareValue;
            });


            // 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
            if (map.get(genre).size() > 1) {
                answer.add(mapList.get(0).getKey());
                answer.add(mapList.get(1).getKey());
            } else answer.add(mapList.get(0).getKey());

        }
        
        return answer.stream().mapToInt(i -> i).toArray();
        
    }
}