import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        sc.nextLine();


        for(int i=0;i<n;i++)
        {
            int m= sc.nextInt();
            sc.nextLine();
            int maximum=-1;
            ArrayList<Integer> array = new ArrayList<>();
            for(int j=0;j<m;j++){
                array.add(sc.nextInt());
            }
            Collections.sort(array);
            if(maximum<array.get(1)-array.get(0)) maximum=array.get(1)-array.get(0);
            if(maximum<array.get(2)-array.get(0)) maximum=array.get(2)-array.get(0);
            if(maximum<array.get(m-1)-array.get(m-2)) maximum=array.get(m-1)-array.get(m-2);
            for(int j=1;j<m-2;j++)
            {
                if(maximum<array.get(j+2)-array.get(j)) maximum=array.get(j+2)-array.get(j);
            }
            System.out.println(maximum);
        }

    }
}
