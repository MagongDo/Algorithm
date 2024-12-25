
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
 
    public static int knapsackOptimized(int N, int W, int[] weights, int[] values) {
        // dp[w]는 배낭의 무게 제한이 w일 때 얻을 수 있는 최대 가치
        int[] dp = new int[W + 1];

        // 각 물건을 하나씩 고려
        for (int i = 0; i < N; i++) {
            // 무게 제한을 뒤에서부터 채워나감 (0/1 배낭에서는 같은 물건을 여러 번 선택하지 않기 위해)
            for (int w = W; w >= weights[i]; w--) {
                dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);
            }
        }

        // 최종 해답
        return dp[W];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        // 물건들의 무게 배열 입력
        int[] weights = new int[N];
        int[] values = new int[N];
        for (int i = 0; i < N; i++) {
            st=new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }



        // 배낭 문제 해결
        int maxValue = knapsackOptimized(N, W, weights, values);
        System.out.println(maxValue);
    }
}
