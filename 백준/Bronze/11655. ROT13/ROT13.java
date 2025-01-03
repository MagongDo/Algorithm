import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        int[] C = new int[26];
        for (int i = 0; i < 26; i++) {
            if (i < 13) {
                C[i] = 13;
            } else {
                C[i] = -13;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                int c = ch - 'A';
                char newChar = (char) ((ch + C[c] - 'A' + 26) % 26 + 'A');
                sb.append(newChar);
            } else if (ch >= 'a' && ch <= 'z') {
                int c = ch - 'a';
                char newChar = (char) ((ch + C[c] - 'a' + 26) % 26 + 'a');
                sb.append(newChar);
            } else {
                sb.append(ch);
            }
        }

        System.out.println(sb);
    }
}
