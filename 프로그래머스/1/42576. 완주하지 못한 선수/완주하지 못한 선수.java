import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // completion으로 map 만들기
        Map<String, Integer> completMap = new HashMap<>();
        for (String name : completion) {
            if (completMap.containsKey(name))
                completMap.put(name, completMap.get(name) + 1);
            else completMap.put(name, 1);
        }
        
        // 1. 참여자중에 completion에 없는 이름이 있으면 return하기
        // 2. 참여자중에 동명이인이 한명 더 있으면 return하기
        for (String name : participant) {
            if (completMap.getOrDefault(name, 0) > 0)
                completMap.put(name, completMap.get(name) - 1);
            else return name;
        }
        
        return "error";
    }
}