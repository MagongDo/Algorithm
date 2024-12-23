import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] parent;

    // Find 연산: 경로 압축 포함
    public static int findParent(int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 게이트의 수 G 입력
        int G = Integer.parseInt(br.readLine());

        // 비행기의 수 P 입력
        int P = Integer.parseInt(br.readLine());

        // 부모 배열 초기화
        parent = new int[G + 1];
        for (int i = 0; i <= G; i++) {
            parent[i] = i;
        }

        int result = 0;

        for (int i = 0; i < P; i++) {
            int gi = Integer.parseInt(br.readLine());

            // 비행기가 도킹할 수 있는 가장 높은 게이트 찾기
            int availableGate = findParent(gi);

            if (availableGate == 0) {
                // 도킹할 수 있는 게이트가 없음, 공항 폐쇄
                break;
            }

            // 도킹 후, 해당 게이트는 사용 불가능하므로 다음 가능한 게이트로 업데이트
            parent[availableGate] = availableGate - 1;
            result++;
        }

        // 결과 출력
        System.out.println(result);
    }
}
