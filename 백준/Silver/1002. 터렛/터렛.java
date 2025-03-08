import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int x1, y1, r1, x2, y2, r2, result;
        double lengthOfTwo;
        int testNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < testNum; i++) {
            // 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());

            // 조규현과 백승환의 거리 구하기
            lengthOfTwo = Math.hypot(Math.abs(x1 - x2), Math.abs(y1 - y2));

            // r1+r2와 비교
            if (x1 == x2 && y1 == y2) {
                result = (r1 == r2) ? -1 : 0;
            } else if (lengthOfTwo < r1 + r2) {
                double sumOfTwoSides = lengthOfTwo + Math.min(r1, r2);
                double side = Math.max(r1, r2);
                result = (sumOfTwoSides > side) ? 2 : (sumOfTwoSides == side) ? 1 : 0;
            } else result = (lengthOfTwo == r1 + r2) ? 1 : 0;

            sb.append(result).append("\n");
        }

        System.out.println(sb.toString());
    }

}