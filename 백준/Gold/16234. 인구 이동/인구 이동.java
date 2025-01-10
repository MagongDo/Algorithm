import java.io.*;
import java.util.*;

public class Main{
    static int[][] arr;
    static Queue<int[]> currentInt;
    static int n, l, r, dayCount = 0, areaCount, areaSum;
    static int[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static boolean check(int x, int y){
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                int diff = Math.abs(arr[nx][ny] - arr[x][y]);
                if(diff >= l && diff <= r){
                    return true;
                }
            }
        }
        return false;
    }

    static void BFS(int a, int b){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, b});
        currentInt.add(new int[]{a, b});
        visited[a][b] = 1;
        areaCount = 1;
        areaSum = arr[a][b];

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n && visited[nx][ny] == 0){
                    int diff = Math.abs(arr[nx][ny] - arr[x][y]);
                    if(diff >= l && diff <= r){
                        visited[nx][ny] = 1;
                        areaCount++;
                        areaSum += arr[nx][ny];
                        queue.add(new int[]{nx, ny});
                        currentInt.add(new int[]{nx, ny});
                    }
                }
            }
        }

        if(areaCount > 1){
            int average = areaSum / areaCount;
            for(int i = 0; i < areaCount; i++){
                int[] current = currentInt.poll();
                int x = current[0];
                int y = current[1];
                arr[x][y] = average;
            }
        } else {
            currentInt.poll();
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        visited = new int[n][n];
        arr = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            boolean moved = false;
            visited = new int[n][n];

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(visited[i][j] == 0 && check(i, j)){
                        currentInt = new LinkedList<>();
                        BFS(i, j);
                        if(areaCount > 1){
                            moved = true;
                        }
                    }
                }
            }

            if(!moved){
                System.out.println(dayCount);
                break;
            }

            dayCount++;
        }
    }
}
