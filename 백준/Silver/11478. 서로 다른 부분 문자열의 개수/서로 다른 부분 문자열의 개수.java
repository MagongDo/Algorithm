import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String,Integer> map = new HashMap<>();

        String S=br.readLine();

        for(int i=0;i<S.length();i++){
            for(int j=0;j<S.length()-i;j++){
                map.put(S.substring(j,i+1+j),map.getOrDefault(S.substring(j,i+1+j),0)+1);
            }
        }
        System.out.println(map.size());
    }
}
