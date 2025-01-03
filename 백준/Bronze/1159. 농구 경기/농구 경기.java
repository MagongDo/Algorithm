import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character,Integer> map=new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String s = br.readLine();
            map.put(s.charAt(0), map.getOrDefault(s.charAt(0),0)+1 );
        }
        List<Character> list=new ArrayList<>(map.keySet());
        boolean check = true;
        for(Character lists :list)
        {
            if(map.get(lists)>=5)
            {
                check = false;
                System.out.print(lists);
            }
        }
        if(check)
        {
            System.out.println("PREDAJA");
        }
    }
}
