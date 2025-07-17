import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static int findAnswer(int N, int M, LinkedList<int[]> q) {
        int cnt = 0;
        while(!q.isEmpty()){
            boolean flag = true;
            // peek이 중요도가 가장 높은지 확인
            for (int i = 0; i < q.size(); i++) {
                if (q.peek()[1] < q.get(i)[1]) {
                    flag = false;
                    break;
                }
            }
            // 중요도가 가장 높으면 pop후 카운트증가
            // 아니면 뒤로 넘기기
            if (flag) {
                int m = q.pop()[0];
                cnt++;
                // M에 해당하는 인덱스가 사라진거면 빠져나오기
                if (m == M)
                    break;
            }
            else  q.offer(q.poll());
        }

        return cnt;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            LinkedList<int[]> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                q.add(new int[]{j, Integer.parseInt(st.nextToken())});
            }

            sb.append(findAnswer(N,M,q)).append("\n");
        }

        System.out.println(sb.toString());
    }

}