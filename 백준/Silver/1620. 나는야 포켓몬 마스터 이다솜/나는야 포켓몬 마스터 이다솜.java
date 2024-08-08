import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> stringMap = new HashMap<>();
        Map<Integer, String> intMap = new HashMap<>();
        String str;
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            stringMap.put(str, i+1);
            intMap.put(i+1, str);
        }

        for (int i = 0; i < M; i++) {
            // 1. 맨 앞글자의 아스키코드 따기
            str = br.readLine();
            int ASCII = str.charAt(0);

            // 2. 찾아서 출력
            if (48 <= ASCII & ASCII <= 57) // 첫번째글자가숫자 > 번호로 포켓몬찾기
                sb.append(intMap.get(Integer.parseInt(str))).append("\n");
            else
                sb.append(stringMap.get(str)).append("\n"); // 포켓몬 이름으로 번호찾기
        }

        System.out.println(sb);

    }
}