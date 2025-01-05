
import java.io.*;

public class Main {


        static boolean test(String password) {
            int countVowels = 0;  
            int countConsonants = 0;  
            boolean containsVowel = false;  

            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);

                boolean isVowel = "aeiou".indexOf(c) != -1;

                if (isVowel) {
                    containsVowel = true;
                    countVowels++;
                    countConsonants = 0;  
                } else {
                    countConsonants++;
                    countVowels = 0;  
                }

                if (countVowels >= 3 || countConsonants >= 3) {
                    return false;
                }

                if (i > 0 && password.charAt(i) == password.charAt(i - 1)) {

                    if (c != 'e' && c != 'o') {
                        return false;
                    }
                }
            }

            return containsVowel;
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line;

            while ((line = br.readLine()) != null) {
                if (line.equals("end")) {
                    break; 
                }

                if (test(line)) {
                    System.out.printf("<%s> is acceptable.\n", line);
                } else {
                    System.out.printf("<%s> is not acceptable.\n", line);
                }
            }
        }
    }
    
