import java.util.*;

public class Main {
    static int N, M;
    static int[][] city;
    static List<int[]> homes = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static boolean[] selected;
    static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        city = new int[N][N];

        // 도시 정보 입력 + 집과 치킨집 위치 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                city[i][j] = sc.nextInt();
                if (city[i][j] == 1) {
                    homes.add(new int[]{i, j});
                } else if (city[i][j] == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        selected = new boolean[chickens.size()];
        // M개 치킨집 선택 (조합)
        backtrack(0, 0);

        System.out.println(minDistance);
    }

    // 백트래킹으로 M개의 치킨집을 선택
    public static void backtrack(int depth, int start) {
        if (depth == M) {
            // 선택된 치킨집으로 치킨 거리 계산
            int total = calculateChickenDistance();
            minDistance = Math.min(minDistance, total);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected[i] = true;
            backtrack(depth + 1, i + 1);
            selected[i] = false;
        }
    }

    // 현재 선택된 치킨집 조합으로 도시의 치킨 거리 계산
    public static int calculateChickenDistance() {
        int sum = 0;
        for (int[] home : homes) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < chickens.size(); i++) {
                if (selected[i]) {
                    int[] chicken = chickens.get(i);
                    int dist = Math.abs(home[0] - chicken[0]) + Math.abs(home[1] - chicken[1]);
                    min = Math.min(min, dist);
                }
            }
            sum += min;
        }
        return sum;
    }
}
