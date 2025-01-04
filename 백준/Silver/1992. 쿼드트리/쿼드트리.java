
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


    public class Main {
        static char[][] a;


        public static String quard(int y, int x, int size) {

            if (size == 1) {
                return String.valueOf(a[y][x]);
            }

            char currentChar = a[y][x];
            boolean isUniform = true;


            outer:
            for (int i = y; i < y + size; i++) {
                for (int j = x; j < x + size; j++) {
                    if (a[i][j] != currentChar) {
                        isUniform = false;
                        break outer;
                    }
                }
            }


            if (isUniform) {
                return String.valueOf(currentChar);
            } else {

                int halfSize = size / 2;
                StringBuilder ret = new StringBuilder();
                ret.append('(');
                ret.append(quard(y, x, halfSize));
                ret.append(quard(y, x + halfSize, halfSize));
                ret.append(quard(y + halfSize, x, halfSize));
                ret.append(quard(y + halfSize, x + halfSize, halfSize));
                ret.append(')');
                return ret.toString();
            }
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            a = new char[n][n];

            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                for (int j = 0; j < n; j++) {
                    a[i][j] = s.charAt(j);
                }
            }

            System.out.println(quard(0, 0, n));
        }
    }

