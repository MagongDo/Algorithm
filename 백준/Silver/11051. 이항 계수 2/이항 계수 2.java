import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] triangle= new int[n+1][n+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=i;j++)
            {
             if(i==j||j==0)triangle[i][j]=1;
                else {
                    triangle[i][j]=(triangle[i-1][j-1]+triangle[i-1][j])%10007;
                }
            }
        }
        System.out.println(triangle[n][m]);
    }
}