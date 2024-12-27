

import java.io.*;
public class Main {
    static int[][] dx;
    static StringBuilder sb=new StringBuilder();
    static int lcs(String a, String b){

        for(int i=1;i<=a.length();i++){
            for(int j=1;j<=b.length();j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dx[i][j]=dx[i-1][j-1]+1;
                }
                else {
                    dx[i][j] = Math.max(dx[i-1][j], dx[i][j-1]);
                }
            }
        }

        return dx[a.length()][b.length()];

    }

    static void printLCS(String a, String b) {
        int i = a.length();
        int j = b.length();
        StringBuilder lcsBuilder = new StringBuilder();

        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                lcsBuilder.append(a.charAt(i - 1));
                i--;
                j--;
            } else if (dx[i - 1][j] > dx[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        sb.append(lcsBuilder.reverse());
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a = br.readLine();
        String b = br.readLine();

        dx = new int[a.length()+1][b.length()+1];
        System.out.println(lcs(a,b));

        if (lcs(a,b) > 0) {
            printLCS(a, b);
            bw.write(sb.toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
