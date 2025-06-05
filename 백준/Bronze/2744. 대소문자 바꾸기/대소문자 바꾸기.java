import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (Character.isUpperCase(c))
                c = Character.toLowerCase(c);
            else if (Character.isLowerCase(c))
                c = Character.toUpperCase(c);

            bw.write(c);
        }

        bw.flush();
    }
}