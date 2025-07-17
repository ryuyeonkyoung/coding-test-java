import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<String>();
        String item;
        int i;

        for (i = 0; i < N; i++){
            item = br.readLine();
            if (!list.contains(item))
                list.add(item);
        }

        //중복 제거 & 정렬
        Collections.sort(list, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                }
                else return s1.length() - s2.length();
            }
        });

        for (String str: list)
            System.out.println(str);
    }
}