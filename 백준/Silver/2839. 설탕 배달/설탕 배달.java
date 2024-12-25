
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public int select(int x)
    {
        int count=0;
        int currentX=x;
        while(true){
        if(currentX>12){
         currentX-=5;
         count++;
        }
        else if(currentX==12||currentX==9||currentX==6||currentX==3)
        {
            currentX-=3;
            count++;
        }
        else if(currentX==11||currentX==10||currentX==8||currentX==7||currentX==5){
            currentX-=5;
            count++;
        }

        if(currentX==1||currentX==2||currentX==4){
            return -1;
        }
        else if(currentX==0)
        {
            return count;
        }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int x= Integer.parseInt(br.readLine());

        Main select=new Main();
        System.out.println(select.select(x));
    }
}
