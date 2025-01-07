import java.io.*;
import java.util.*;
public class Main {
    static int n, m;
    static int[][] arr;
    static int[][] visited;
    static int count = 0;
    static int answer = 0;
    static int mincount = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static void BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && visited[nx][ny]==0) {
                    if (arr[nx][ny] == 1) {
                        visited[nx][ny] = 1;
                        count--;
                        arr[nx][ny] = 0;
                    } else {
                        visited[nx][ny] = 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        if (count != 0) {
            mincount = count;
        }
        answer++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) count++;
            }
        }
        mincount = count;
        while (true) {
            if (count != 0) {
                visited = new int[n][m];
                BFS();
            } else break;
        }
        System.out.println(answer);
        System.out.println(mincount);

    }
}

