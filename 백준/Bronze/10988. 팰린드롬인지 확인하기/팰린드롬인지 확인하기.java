
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s=br.readLine();

        int left=0,right=s.length()-1;
        boolean check=false;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                check = true;
                break;}
            left++;
            right--;
        }
        if(check){
            System.out.println(0);
        }
        else{
            System.out.println(1);
        }
    }
}
