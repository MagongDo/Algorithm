import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] cnt = new int[256];
        for (char a : s.toCharArray()) {
            cnt[a]++;
        }

        StringBuilder ret = new StringBuilder();
        char mid = 0;
        int flag = 0;  
        for (int i = 'Z'; i >= 'A'; i--) {
            if (cnt[i] > 0) {
                if (cnt[i] % 2 == 1) {
                    mid = (char) i;
                    flag++;
                    cnt[i]--;
                }
                if (flag == 2) {
                    break;
                }
                for (int j = 0; j < cnt[i] / 2; j++) {
                    ret.insert(0, (char) i);   
                    ret.append((char) i);     
                }
            }
        }

        if (flag > 1) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            if (mid != 0) {
                ret.insert(ret.length() / 2, mid);
            }
            System.out.println(ret.toString());
        }
    }
}
