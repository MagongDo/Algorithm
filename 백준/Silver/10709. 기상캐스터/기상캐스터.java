
import java.io.*;
import java.util.*;
public class Main {
    static int n,m;
    static String[] arrayS;
    static int[][] arrayI;
    static void BFS(int x, int y)
    {
        for(int i=y;i<m;i++){
            if(arrayS[x].charAt(i)=='c'){
                arrayI[x][i]=0;
            }
            else{
                arrayI[x][i]=arrayI[x][i-1];
                arrayI[x][i]+=1;
            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arrayS = new String[n];
        arrayI = new int[n][m];

        for(int i=0;i<n;i++){
            arrayS[i] = br.readLine();
            for(int j=0;j<m;j++){
                arrayI[i][j] = -1;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arrayS[i].charAt(j)=='c'){
                    BFS(i,j);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arrayI[i][j]+" ");
            }
            System.out.println();
        }
    }
}
