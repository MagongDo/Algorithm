import java.io.*;
import java.util.*;

public class Main {

    static final int MAX_N = 500000;
    static int[][] visited = new int[2][MAX_N + 4];

    public static int BFS(int a, int b) {
        Queue<Integer> queue = new LinkedList<>();
        visited[0][a] = 1;
        queue.add(a);

        int turn = 1;
        while (!queue.isEmpty()) {
            b += turn;
            if (b > MAX_N) break;
            if (visited[turn % 2][b] != 0) return turn;

            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                int x = queue.poll();
                for (int nx : new int[]{x + 1, x - 1, x * 2}) {
                    if (nx < 0 || nx > MAX_N || visited[turn % 2][nx] != 0) continue;
                    visited[turn % 2][nx] = visited[(turn + 1) % 2][x] + 1;
                    if (nx == b) return turn;
                    queue.add(nx);
                }
            }
            turn++;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (n == m) {
            System.out.println(0);
        } else {
            int result = BFS(n, m);
            System.out.println(result);
        }
    }


}
