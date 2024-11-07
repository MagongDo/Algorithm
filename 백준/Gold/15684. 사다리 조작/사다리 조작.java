import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 987654321;
    static int n, m, h, a, b, ret = INF;
    static int[][] visited = new int[35][35];

    static boolean check() {
        for (int i = 1; i <= n; i++) {
            int start = i;
            for (int j = 1; j <= h; j++) {
                if (visited[j][start] == 1) {
                    start++;
                } else if (visited[j][start - 1] == 1) {
                    start--;
                }
            }
            if (start != i) return false;
        }
        return true;
    }

    static void go(int here, int cnt) {
        if (cnt > 3 || cnt >= ret) return;
        if (check()) {
            ret = Math.min(ret, cnt);
            return;
        }
        for (int i = here; i <= h; i++) {
            for (int j = 1; j < n; j++) {
                if (visited[i][j] == 1 || visited[i][j - 1] == 1 || visited[i][j + 1] == 1)
                    continue;
                visited[i][j] = 1;
                go(i, cnt + 1);
                visited[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            visited[a][b] = 1;
        }

        go(1, 0);
        System.out.println((ret == INF) ? -1 : ret);
    }
}