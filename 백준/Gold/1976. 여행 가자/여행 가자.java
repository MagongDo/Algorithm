

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] parent;

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // 부모를 루트로 갱신 (경로 압축)
        }
        return parent[x];
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX; // 두 집합을 합침
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 도시 수 입력
        int n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];

        // 초기화: 자기 자신을 부모로 설정
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // 여행 계획에 포함된 도시 수 입력
        int m = Integer.parseInt(br.readLine());

        // 연결 정보 입력 및 Union 연산 수행
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int connected = Integer.parseInt(st.nextToken());
                if (connected == 1) {
                    union(i, j);
                }
            }
        }

        // 여행 계획 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] plan = new int[m];
        for (int i = 0; i < m; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }

        // 여행 계획의 모든 도시가 같은 집합인지 확인
        boolean possible = true;
        int root = find(plan[0]); // 첫 번째 도시의 루트를 기준으로 비교
        for (int i = 1; i < m; i++) {
            if (find(plan[i]) != root) { // 다른 도시가 다른 집합에 속해 있다면
                possible = false;
                break;
            }
        }

        // 결과 출력
        System.out.println(possible ? "YES" : "NO");
    }
}