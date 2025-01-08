import java.util.*;
import java.io.*;
public class Main {
    static int n,m, maxCount=0;
    static int[][] mapInt,visited;
    static String[] arr;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static Queue<int[]> queue;
    static void BFS(int a, int b){
        visited[a][b] = 1;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for(int k=0;k<4;k++){
                int nx = x+dx[k];
                int ny = y+dy[k];
                if(nx>=0&&ny>=0&&nx<n&&ny<m){
                    if(arr[nx].charAt(ny)=='L'&&visited[nx][ny]==0){
                        visited[nx][ny]=1;
                        mapInt[nx][ny]=mapInt[x][y]+1;
                       maxCount=Math.max( mapInt[nx][ny],maxCount);
                        queue.add(new int[]{nx,ny});
                    }

                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new String[n];
        int max = -1;
        for (int i = 0; i < n; i++) {
            arr[i]= br.readLine();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i].charAt(j)=='L'){
                    queue=new LinkedList<>();
                    queue.add(new int[]{i,j});
                    visited = new int[n][m];
                    mapInt = new int[n][m];
                    maxCount=0;
                    BFS(i,j);
                    if(maxCount>max){
                        max=maxCount;
                    }
                }
            }
        }
        System.out.println(max);

    }
}
