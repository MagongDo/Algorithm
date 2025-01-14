import java.io.*;
import java.util.*;
public class Main {

        static int[][][] dp = new int[64][64][64];
        static int[][][] visited = new int[64][64][64];
        static int[][] dxy = {{1,9,3},
                {1,3,9},
                {3,1,9},
                {3,9,1},
                {9,1,3},
                {9,3,1}};
      static int BFS(int a, int b, int c)
{
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{a, b, c});
    visited[a][b][c] = 1; 

    while(!queue.isEmpty()){
        int[] current = queue.poll();
        int x = current[0];
        int y = current[1];
        int z = current[2];

        if(x == 0 && y == 0 && z == 0) {
            return visited[x][y][z] - 1;
        }

        for(int i = 0; i < 6; i++){
            int nx = Math.max(0, x - dxy[i][0]);
            int ny = Math.max(0, y - dxy[i][1]);
            int nz = Math.max(0, z - dxy[i][2]);

            if(visited[nx][ny][nz] == 0){
                visited[nx][ny][nz] = visited[x][y][z] + 1;
                queue.add(new int[]{nx, ny, nz});
            }
        }
    }
    return 0; 
}

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



            int n= Integer.parseInt(br.readLine());
            int[] arr = new int[3];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }
            System.out.println(BFS(arr[0],arr[1],arr[2]));

        }
    }

