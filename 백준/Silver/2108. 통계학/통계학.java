import java.io.*;
import java.util.*;

public class Main {
    public static int findFrequence(int arr[]) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else map.put(arr[i], 1);
        }

        int max_count = Collections.max(map.values());
        int finalMax_count = max_count;
        List<Integer> list = new ArrayList<>();
        map.forEach((key, value) -> {
            if (value == finalMax_count)
                list.add(key);
        });
        Collections.sort(list);

        if (list.size() == 1)
            return list.get(0);
        else return list.get(1);
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double sum = 0;

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];

        // 1.산술평균
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        bw.write(Math.round(sum/N) + "\n");

        // 2.중앙값
        Arrays.sort(arr);
        bw.write(arr[arr.length/2] + "\n");

        // 3. 최빈값
        bw.write(findFrequence(arr) + "\n");

        // 4. 범위
        bw.write(Integer.toString(arr[arr.length - 1] - arr[0]));

        bw.flush();
        bw.close();
    }
}