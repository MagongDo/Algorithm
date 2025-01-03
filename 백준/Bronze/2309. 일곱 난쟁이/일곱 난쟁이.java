
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] n = new int[9];
        int sum = 0;
        for(int i=0;i<9;i++)
        {
            n[i] = Integer.parseInt(br.readLine());
            sum += n[i];
        }
        int a =0;
        int b =0;
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++){
                if(i==j) continue;
                if(sum-n[i]-n[j]==100)
                {
                 a=i;
                 b=j;
                 break;
                }
            }
            if(a!=0 && b!=0) break;
        }
        List<Integer> arr = new ArrayList<Integer>();
        for(int i=0;i<9;i++)
        {
            if(i!=a&&i!=b) {
                arr.add(n[i]);
            }
        }
        Collections.sort(arr);
        for(int i=0;i<arr.size();i++) {
            System.out.println(arr.get(i));
        }

    }
}
