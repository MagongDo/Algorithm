

import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int max = 0;
    static int count = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        int mc = 1; // 시작점 포함
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int nx = cur[0];
            int ny = cur[1];

            for (int i = 0; i < 4; i++) {
                int curX = nx + dx[i];
                int curY = ny + dy[i];

                if (curX >= 0 && curY >= 0 && curX < n && curY < m) {
                    if (!visited[curX][curY] && arr[curX][curY] == 1) {
                        visited[curX][curY] = true;
                        q.add(new int[]{curX, curY});
                        mc++; // 넓이 증가
                    }
                }
            }
        }

        if (mc > max) {
            max = mc;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); // 행
        n = Integer.parseInt(st.nextToken()); // 열

        arr = new int[n][m]; // [행][열]
        visited = new boolean[n][m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j][i] = Integer.parseInt(st.nextToken()); // 올바른 입력 방향
            }
        }

        for (int i = 0; i < n; i++) { // 행
            for (int j = 0; j < m; j++) { // 열
                if (arr[i][j] == 1 && !visited[i][j]) {
                    BFS(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }
}
