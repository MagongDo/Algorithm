import java.io.*;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] dx = {0, 0, -1, 1, 0, 0};
    private static int[] dy = {0, 0, 0, 0, -1, 1};
    private static int[] dz = {1, -1, 0, 0, 0, 0};

    public static int BFS(int N, int M ,int K, int[][][] array, Queue<int[]> queue){
        Queue<int[]> queue1 = new ArrayDeque<>(queue);

        while(!queue1.isEmpty()){
            int[] current = queue1.poll();
            int x = current[0];
            int y = current[1];
            int z = current[2];
            for(int i=0;i<6;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if(nx >=0 && nx<K && ny>=0 && ny<M && nz>=0 && nz<N && array[nx][ny][nz]==0){
                    array[nx][ny][nz]=array[x][y][z]+1;
                    queue1.add(new int[]{nx,ny,nz});
                }
            }
        }
        int maxDays=0;
        for(int i=0;i<K;i++){
            for(int j=0;j<M;j++){
                for(int k=0;k<N;k++){
                    if(array[i][j][k]==0){
                        return-1;
                    }
                    maxDays=Math.max(maxDays,array[i][j][k]);
                }
            }
        }
        return maxDays-1;



    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<int[]> queue = new ArrayDeque<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][][] array = new int[K][M][N];

        for(int i=0;i<K;i++)
        {
            for(int j=0;j<M;j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<N;k++)
                {
                    array[i][j][k] = Integer.parseInt(st.nextToken());
                    if(array[i][j][k] == 1){
                        queue.add(new int[] {i,j,k} );
                    }
                }
            }
        }
        System.out.println(BFS(N,M,K,array,queue));

    }
}
