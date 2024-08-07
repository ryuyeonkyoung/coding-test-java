import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        HashSet set = new HashSet();

        String n;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "add":
                    n = st.nextToken();
                    if(!set.contains(n))
                        set.add(n);
                    break;
                case "remove":
                    n = st.nextToken();
                    if(!set.isEmpty())
                        set.remove(n);
                    break;
                case "check":
                    boolean check;
                    if (set.isEmpty())
                        check = false;
                    check = set.contains(st.nextToken());
                    if (check)
                        sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case "toggle":
                    n = st.nextToken();
                    if (set.contains(n))
                        set.remove(n);
                    else set.add(n);
                    break;
                case "all":
                    set.clear();
                    for (int j = 1; j <= 20; j++) {
                        set.add(Integer.toString(j));
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
        System.out.println(sb);
    }
}