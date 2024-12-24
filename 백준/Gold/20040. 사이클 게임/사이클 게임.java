import java.util.Scanner;

public class Main {
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 점의 개수
        int m = sc.nextInt(); // 진행된 차례 수

        parent = new int[n];
        // 초기화: 자기 자신을 부모로 설정
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int result = 0; // 사이클이 완성된 차례 번호 (없으면 0)

        for (int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            // 사이클이 이미 발생하지 않았다면 두 점을 연결
            if (find(a) == find(b)) {
                result = i; // 사이클이 처음 발생한 차례
                break;
            } else {
                union(a, b);
            }
        }

        System.out.println(result);
        sc.close();
    }

    // Find 연산 (경로 압축 적용)
    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // 부모를 루트로 갱신
        }
        return parent[x];
    }

    // Union 연산 (Union by rank는 생략 - 필요시 추가 가능)
    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX; // 한 쪽을 다른 쪽의 루트로 설정
        }
    }
}