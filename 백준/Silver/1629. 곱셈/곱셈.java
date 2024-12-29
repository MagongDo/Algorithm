import java.util.Scanner;

public class Main {

    // 모듈러 거듭제곱 함수
    public static long modExp(long a, long b, long c) {
        long result = 1;  // 결과값
        a = a % c;  // a를 c로 나눈 나머지로 초기화

        while (b > 0) {
            if (b % 2 == 1) {  // B가 홀수일 때
                result = (result * a) % c;
            }
            a = (a * a) % c;  // a를 제곱하고 mod c를 취함
            b = b / 2;  // b를 반으로 줄임
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력 받기
        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();
        
        // 결과 출력
        System.out.println(modExp(A, B, C));
        
        sc.close();
    }
}
