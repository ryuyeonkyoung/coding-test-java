import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Person {
        int age;
        String name;

        public Person(int age, String name){
            this.age = age;
            this.name = name;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[][] list = new String[N][2];
        String[] str;
        int i;

        //배열 채워넣기(0:나이, 1:이름)
        for (i = 0; i < N; i++){
            str = br.readLine().split(" ");
            list[i][0] = str[0];
            list[i][1] = str[1];
        }

        Arrays.sort(list, (s1, s2) -> {
            return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
        });

        for (i = 0; i < list.length; i++){
            System.out.println(list[i][0] + " " + list[i][1]);
        }
    }
}