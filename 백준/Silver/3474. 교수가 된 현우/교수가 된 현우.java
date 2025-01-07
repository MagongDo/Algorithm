import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            int a = Integer.parseInt(br.readLine());
            int ret2=0,ret5=0;
            for(int j=2;j<=a;j*=2){
                ret2+=a/j;
            }
            for(int j=5;j<=a;j*=5){
                ret5+=a/j;
            }
            System.out.println(Math.min(ret2,ret5));
        }
    }
}