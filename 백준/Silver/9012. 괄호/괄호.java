import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        Queue<String> q = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int IS_PS = 1;

        int T = Integer.parseInt(br.readLine().strip());
        String[] result = new String[T];
        for (int i = 0; i < T; i++) {
            IS_PS = 1;
            q.clear();
            String[] str = br.readLine().strip().split("(?<=.)");
            for (String s : str){
                if (s.equals("(")){
                    q.add("(");
                } else if (s.equals(")") && !q.isEmpty()){
                    q.remove();
                } else{
                    IS_PS = 0;
                    break;
                }
            }
            if (IS_PS == 1 && q.isEmpty())
                result[i] = "YES";
            else
                result[i] = "NO";
        }

        for (String s : result){
            if (s==null)
                break;
            System.out.println(s);
        }
    }
}