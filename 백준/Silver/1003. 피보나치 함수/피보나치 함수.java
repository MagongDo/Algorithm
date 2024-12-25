
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] dx0=new int[41];
    public static int[] dx1=new int[41];

    public void fib(int n){
        dx0[0]=1;
        dx0[1]=0;
        dx1[0]=0;
        dx1[1]=1;

        for(int i=2;i<=n;i++){
            dx0[i]=dx0[i-1]+dx0[i-2];
            dx1[i]=dx1[i-1]+dx1[i-2];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.parseInt(br.readLine());
        Main fib=new Main();
        fib.fib(40);
        for(int i=0;i<n;i++){
            int m=Integer.parseInt(br.readLine());
            System.out.println(dx0[m]+" "+dx1[m]);
        }
    }
}
