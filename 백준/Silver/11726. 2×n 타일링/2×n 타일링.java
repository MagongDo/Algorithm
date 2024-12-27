import java.io.*;
public class Main {

    static int[] dx;
    static int tailing(int n)
    {
        dx[0]=1;
        if(n>=1) dx[1]=1;

        for(int i=2;i<=n;i++){
            dx[i]=(dx[i-1]+dx[i-2])%10007;
        }
        return dx[n];
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dx = new int[n+1];
        System.out.println(tailing(n));
    }
}
