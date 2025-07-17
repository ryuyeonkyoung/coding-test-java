import java.io.*;
import java.util.Stack;

public class Main {
    public static boolean isThereBalance(String str) {
        str.replace( " ", "");
        char[] charArray = str.toCharArray();
        Stack<Character> stack = new Stack();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '[' || charArray[i] == ']' || charArray[i] == '(' || charArray[i] == ')') {
                switch (charArray[i]) {
                    case '[':
                        stack.push('[');
                        break;
                    case '(':
                        stack.push('(');
                        break;
                    case ']':
                        if (stack.isEmpty())
                            return false;
                        if (stack.peek() == '[')
                            stack.pop();
                        else return false;
                        break;
                    case ')':
                        if (stack.isEmpty())
                            return false;
                        if (stack.peek() == '(')
                            stack.pop();
                        else return false;
                        break;
                }
            }
        }
        if (stack.isEmpty())
            return true;
        else return false;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String str = br.readLine();
            if (str.equals("."))
                break;
            else if (isThereBalance(str))
                bw.write("yes\n");
            else bw.write("no\n");
        }

        bw.flush();
        bw.close();

    }
}