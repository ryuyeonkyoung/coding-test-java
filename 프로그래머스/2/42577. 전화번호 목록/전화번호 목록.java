import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        // 중간에 있으면 안되고 접두사로 있어야함
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                if (phone_book[j].contains(phone_book[i])
                    && phone_book[j].indexOf(phone_book[i]) == 0) {
                    return false;
                } else break;
            }

        }

        return true;
    }
}