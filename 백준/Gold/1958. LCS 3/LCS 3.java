

import java.util.*;
import java.io.*;
public class Main {
        static int[][][] dx;
    public static int findMaxNested(int a, int b, int c) {
        if (a >= b) {
            if (a >= c) {
                return a;
            } else {
                return c;
            }
        } else {
            if (b >= c) {
                return b;
            } else {
                return c;
            }
        }
    }
    static int lcs3(String a, String b, String c) {

        for(int i=1;i<=a.length();i++)
        {
            for(int j=1;j<=b.length();j++)
            {
                for(int k=1;k<=c.length();k++)
                {
                    if(a.charAt(i-1)==b.charAt(j-1)&&a.charAt(i-1)==c.charAt(k-1)){
                        dx[i][j][k]=dx[i-1][j-1][k-1]+1;
                    }
                    else{
                        dx[i][j][k]=findMaxNested(dx[i-1][j][k],dx[i][j-1][k],dx[i][j][k-1]);
                    }
                }
            }
        }

        return dx[a.length()][b.length()][c.length()];

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B= br.readLine();
        String C= br.readLine();

        dx= new int[A.length()+1][B.length()+1][C.length()+1];

        System.out.println(lcs3(A,B,C));

    }
}
