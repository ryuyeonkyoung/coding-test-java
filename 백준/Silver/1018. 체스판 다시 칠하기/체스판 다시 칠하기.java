import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static int repaint(char[][] arr, int X_index, int Y_index)
    {
        int i,j, repaint = 0;

        //맨처음 B일 때-repaint
        for (i = X_index; i < X_index + 8; i++) {
            for (j = Y_index; j < Y_index + 8; j++) {
                if ((i + j) % 2 == 0) { //B
                    if (arr[i][j] != 'B')
                        repaint++;
                }
                else { //W
                    if (arr[i][j] != 'W')
                        repaint++;
                }
            }
        }

        return Math.min(repaint, 64 - repaint);
    }

    public static void main(String[] args) throws IOException {
        //StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        char[] ch;
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        char[][] M_arr = new char[N][M];
        int i, j, a;
        int M_repaint = 64;

        for (i = 0; i < N; i++) {
            ch = br.readLine().toCharArray();
            for (j = 0; j < M; j++)
                M_arr[i][j] = ch[j];
        }

        for (i = 0; i <= N - 8; i++) {
            for (j = 0; j <= M - 8; j++) {
                a = repaint(M_arr, i, j);
                if (a < M_repaint)
                    M_repaint = a;
            }
        }


        System.out.println(M_repaint);
    }
}