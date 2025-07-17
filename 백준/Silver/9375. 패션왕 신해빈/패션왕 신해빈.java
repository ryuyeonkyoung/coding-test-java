import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            HashMap<String, LinkedList<String>> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String value = st.nextToken();
                String key = st.nextToken();

                // key가 hashmap에 없으면 새 linkedlist생성
                if (!map.containsKey(key))
                    map.put(key, new LinkedList<>());

                map.get(key).add(value);
            }

            // 결과물 계산
            int sum = 1;
            for (LinkedList<String> list : map.values()) {
                sum *= list.size() + 1;
            }
            sum -= 1;
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}