
import java.io.*;
public class Main {
    public static int[][] dx;

    public int LCS(String a, String b) {

        for(int i=1;i<=a.length();i++){
            for(int j=1;j<=b.length();j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dx[i][j]=dx[i-1][j-1]+1;
                }
                else{
                    dx[i][j]=Math.max(dx[i-1][j],dx[i][j-1]);
                }
            }
        }
        return dx[a.length()][b.length()];
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String A=br.readLine();
        String B=br.readLine();

        dx=new int[A.length()+1][B.length()+1];

        Main lcs=new Main();

        System.out.println(lcs.LCS(A,B));

    }
}
