import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(br.readLine());

        int l = 1; 
        int ret = 0; 

        for(int i = 0; i < j; i++) {
            int r = l + m - 1;
            int temp = Integer.parseInt(br.readLine());
            if(temp >= l && temp <= r) {
                continue; 
            } else {
                if(temp < l) {
                    ret += (l - temp); 
                    l = temp; 
                } else {
                    ret += (temp - r); 
                    l += (temp - r); 
                }
            }
        }
        System.out.println(ret);
    }
}
