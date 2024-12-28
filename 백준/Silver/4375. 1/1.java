import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String inputLine = sc.nextLine().trim();
            if (inputLine.isEmpty()) break;

            int n = Integer.parseInt(inputLine);

            // n이 2 또는 5로 나누어 떨어지는 경우는 문제에서 제외됨
            // 하지만 안전하게 처리
            if (n % 2 == 0 || n % 5 == 0) {
                System.out.println(-1); // 문제의 조건에 맞지 않는 입력
                continue;
            }

            int result = findSmallestMultipleLength(n);
            System.out.println(result);
        }

        sc.close();
    }

    // 주어진 n에 대해 모든 자릿수가 1인 가장 작은 n의 배수의 길이를 찾는 메서드
    public static int findSmallestMultipleLength(int n) {
        // 방문한 나머지를 추적하기 위한 배열
        boolean[] visited = new boolean[n];

        // 현재까지의 나머지와 자릿수
        int remainder = 1 % n;
        int length = 1;

        while (remainder != 0 && !visited[remainder]) {
            visited[remainder] = true;
            // 다음 숫자는 현재 숫자에 '1'을 추가한 것과 같으므로, (remainder * 10 + 1) % n
            remainder = (remainder * 10 + 1) % n;
            length++;

            // 최대 n번 반복
            if (length > n) {
                // 이론적으로 n이 2 또는 5의 배수가 아닐 경우 반드시 답이 존재함
                // 따라서 이 경우는 발생하지 않아야 함
                return -1;
            }
        }

        return remainder == 0 ? length : -1;
    }
}

