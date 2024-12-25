
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public int select(int x)
    {
        int count=0;
        while(x>=0){
            if(x%5==0)
            {
                count+=x/5;
                return count;
            }
            x-=3;
            count++;
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int x= Integer.parseInt(br.readLine());

        Main select=new Main();
        System.out.println(select.select(x));
    }
}
