

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// 1249. [S/W 문제해결 응용] 4일차 - 보급로
public class Solution {

	static char[][] charArr;
	static int[][] dist;
	static boolean[][] visited;
	static int N;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

    static class Node implements Comparable<Node> {
    	int x, y, weight;

    	Node(int x, int y, int weight) {
    		this.x = x;
    		this.y = y;
    		this.weight = weight;
    	}

		@Override
		public int compareTo(Node n) {
			return weight - n.weight;
		}

    }

    public static void dijkstra() {
    	for (int i = 0; i < N; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;

    	PriorityQueue<Node> q = new PriorityQueue<>();
    	q.offer(new Node(0,0,0));

    	while (!q.isEmpty()) {
            Node curr = q.poll();
            int x = curr.x, y = curr.y, w = curr.weight;
            if (visited[x][y]) continue;
            if (x == N-1 && y == N-1) break;

            visited[x][y] = true;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx<0 || ny<0 || nx>=N || ny>=N) continue;
                int nw = w + (charArr[nx][ny] - '0');
                if (nw < dist[nx][ny]) {
                    dist[nx][ny] = nw;
                    q.offer(new Node(nx, ny, nw));
                }
            }
    	}
    }

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("res/1249_input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int test_case=1; test_case<=T; test_case++) {
        	// 입력
            N = sc.nextInt();
            charArr = new char[N][N];
            visited = new boolean[N][N];
            dist = new int[N][N];
            for (int i = 0; i<N; i++) {
            	String s = sc.next();
            	charArr[i] = s.toCharArray();
            }

            dijkstra();

            System.out.println("#"+test_case+" "+dist[N-1][N-1]);
        }
    }
}

