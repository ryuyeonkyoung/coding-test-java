import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean flag = false;
        boolean isreverse = false;

        int T = Integer.parseInt(br.readLine());
        int n;
        for (int i = 0; i <T; i++) {
            char[] order = br.readLine().toCharArray();
            n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            str = str.substring(1, str.length() - 1);
            String[] arr = str.split(",");
            List<String> fixedlist = Arrays.asList(arr);
            List<String> list = new ArrayList<>(fixedlist);
            if (n == 0)
                list.clear();

            // 명령 실행
            flag = false;
            isreverse = false;
            int rmcnt = 0;
            int reversermcnt = 0;
            for (int j = 0; j < order.length; j++) {
                switch (order[j]) {
                    case 'R':
                        if (isreverse)
                            isreverse = false;
                        else isreverse = true;
                        break;
                    case 'D':
                        if (list.isEmpty())
                            flag = true;
                        else if (!isreverse)
                            rmcnt++;
                        else reversermcnt++;
                        break;
                    default:
                        if (flag)
                            break;
                }
            }

            // RD 명령 처리
            if (n < reversermcnt+rmcnt)
                flag = true;
            else
                list = list.subList(rmcnt, list.size() - reversermcnt);
            if (isreverse)
                Collections.reverse(list);
            
            // 출력
            if (flag) {
                bw.write("error\n");
            } else {
                bw.write("[");
                if (!list.isEmpty()) {
                    for (int j = 0; j < list.size() - 1; j++) {
                        bw.write(list.get(j) + ",");
                    }
                    bw.write(list.get(list.size()-1));
                }
                bw.write("]\n");
            }
        }

        bw.flush();
        bw.close();
    }
}