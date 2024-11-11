import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int[] minArr = new int[4];  // 최소 요구 영양소
    static int[] sumArr = new int[4];  // 현재 선택된 영양소 합
    static int[][] arr;                // 재료 정보 배열
    static int N;
    static int minCost = Integer.MAX_VALUE;  // 최소 비용
    static List<Integer> answerArr = new ArrayList<>();  // 최소 비용 재료 집합
    static List<Integer> tempArr = new ArrayList<>();    // 현재 탐색 중인 재료 집합

    // 백트래킹 탐색
    public static void DFS(int index, int cost) {
        // 현재 영양소 합이 최소 요구 기준을 만족하는 경우
        if (sumArr[0] >= minArr[0] && sumArr[1] >= minArr[1] &&
                sumArr[2] >= minArr[2] && sumArr[3] >= minArr[3]) {

            // 최소 비용 갱신
            if (cost < minCost) {
                minCost = cost;
                answerArr = new ArrayList<>(tempArr);
            }
            // 같은 비용이지만 사전순으로 더 빠른 경우 갱신
            else if (cost == minCost) {
                if (compareLists(tempArr, answerArr)) {
                    answerArr = new ArrayList<>(tempArr);
                }
            }
            return;
        }

        // 재료를 모두 탐색한 경우 종료
        if (index == N) {
            return;
        }

        // 현재 재료 선택하는 경우
        tempArr.add(index + 1);
        for (int i = 0; i < 4; i++) {
            sumArr[i] += arr[index][i];
        }
        DFS(index + 1, cost + arr[index][4]);

        // 현재 재료 선택하지 않는 경우 (원상 복구)
        tempArr.remove(tempArr.size() - 1);
        for (int i = 0; i < 4; i++) {
            sumArr[i] -= arr[index][i];
        }
        DFS(index + 1, cost);
    }

    // 사전순 비교 함수
    public static boolean compareLists(List<Integer> list1, List<Integer> list2) {
        for (int i = 0; i < list1.size(); i++) {
            if (i >= list2.size() || list1.get(i) < list2.get(i)) {
                return true;
            } else if (list1.get(i) > list2.get(i)) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][5];

        // 최소 요구 영양소 입력
        for (int i = 0; i < 4; i++) {
            minArr[i] = sc.nextInt();
        }

        // 각 재료 정보 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 백트래킹 시작
        DFS(0, 0);

        // 결과 출력
        if (minCost == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(minCost);
            for (int num : answerArr) {
                System.out.print(num + " ");
            }
        }
    }
}