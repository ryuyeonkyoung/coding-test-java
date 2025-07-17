import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] str;
        String[] S;
        int i, j, n;

        for(n = 0; n < T; n++)
        {
            //테스트 케이스 입력받기
            str = br.readLine().split(" ");
            //str에서 숫자, 문자열 분리
            int R = Integer.parseInt(str[0]);
            S = str[1].split("");
            //출력
            for (i = 0; i < S.length; i++)
                for (j = 0; j < R; j++)
                    System.out.print(S[i]);
            System.out.print("\n");
        }

    }
}