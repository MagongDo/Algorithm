import java.util.Scanner;

public class Main {

    // 문자열이 회문인지 확인하는 메서드
    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 유사회문 판별 메서드
    private static int checkPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                // 왼쪽 문자를 제거한 경우
                if (isPalindrome(s, left + 1, right)) {
                    return 1; // 유사회문
                }
                // 오른쪽 문자를 제거한 경우
                if (isPalindrome(s, left, right - 1)) {
                    return 1; // 유사회문
                }
                return 2; // 일반 문자열
            }
        }
        return 0; // 회문
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 문자열의 개수
        sc.nextLine(); // 개행 문자 제거

        for (int i = 0; i < T; i++) {
            String s = sc.nextLine().trim();
            System.out.println(checkPalindrome(s));
        }

        sc.close();
    }
}
