

import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int s = Integer.parseInt(br.readLine());
        String array = br.readLine();
        for(int i=0 ; i <n;i++)
        {
            if(i==0)
            {
            sb.append("I");
            }
            sb.append("O");
            sb.append("I");
        }
        String answer = sb.toString();
        int count=0;
        for(int i = 0; i < s; i++){
            if(array.charAt(i)=='I')
            {
                if(i+(n*2+1)<=s) {
                    if (array.substring(i, i + (n * 2 + 1)).equals(answer)) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
