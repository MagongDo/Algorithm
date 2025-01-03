
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max=0;
        int sum=0;
        for(int i=0;i<n;i++){
            if(i-1+m>=n) break;
            if(i==0)
            {
                for(int j=0;j<m;j++)
                {
                  sum+=arr[j];
                }
                max=sum;
            }
            else{
                sum-=arr[i-1];
                sum+=arr[i-1+m];
                max=Math.max(sum,max);
            }
        }
        System.out.println(max);
    }
}
