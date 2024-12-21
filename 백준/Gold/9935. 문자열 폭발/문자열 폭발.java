
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        String original = br.readLine();
        String bomb = br.readLine();

        // 폭발 문자열의 길이와 마지막 문자 저장
        int bombLength = bomb.length();
        char bombLastChar = bomb.charAt(bombLength - 1);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < original.length(); i++) {
            char currentChar = original.charAt(i);
            sb.append(currentChar);

            // 현재 문자가 폭발 문자열의 마지막 문자와 같고, 스택의 길이가 폭발 문자열의 길이 이상일 때
            if(currentChar == bombLastChar && sb.length() >= bombLength) {
                boolean isBomb = true;

                // 폭발 문자열과 일치하는지 확인
                for(int j = 0; j < bombLength; j++) {
                    if(sb.charAt(sb.length() - bombLength + j) != bomb.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }

                // 일치하면 폭발 문자열의 길이만큼 제거
                if(isBomb) {
                    sb.delete(sb.length() - bombLength, sb.length());
                }
            }
        }

        // 결과 출력
        if(sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }
    }
}
