import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        Stack<Integer> stack = new Stack();
        int find;
        boolean error = false;

        int n = Integer.parseInt(br.readLine());
        int index = 1;
        for (int i = 0; i < n; i++) {
            find = Integer.parseInt(br.readLine());
            if(find < index){
                if (stack.peek() == find){
                    stack.pop();
                    sb.append("-\n");
                } else {
                    error = true;
                    break;
                }
            }
            else {
                while(find >= index) {
                    stack.push(index++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }
        }

        if (error){
            System.out.println("NO");
        } else{
            String result = sb.toString();
            System.out.println(result);
        }
    }
}