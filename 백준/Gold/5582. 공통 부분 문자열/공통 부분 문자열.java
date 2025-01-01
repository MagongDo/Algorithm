import java.io.*;

public class Main {
    public static int longestCommonSubstring(String a, String b) {
        int max = 0;
        int n = a.length();
        int m = b.length();
        
        int[] dp = new int[m + 1];
        
        for (int i = 1; i <= n; i++) {
            int[] current = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    current[j] = dp[j - 1] + 1;
                    if (current[j] > max) {
                        max = current[j];
                    }
                } else {
                    current[j] = 0;
                }
            }
            dp = current;
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        System.out.println(longestCommonSubstring(a, b));
    }
}
