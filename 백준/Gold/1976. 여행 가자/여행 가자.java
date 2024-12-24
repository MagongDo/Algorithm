
import java.util.Scanner;

public class Main {

    public static int[] parent;
    static int find(int x)
    {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // 부모를 루트로 갱신
        }
        return parent[x];
    }

    static void union(int x, int y)
    {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY]=rootX;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        parent = new int[n+1];
        int m=sc.nextInt();
        sc.nextLine();
        for(int i=1;i<=n;i++){
            parent[i]=i;
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                int s = sc.nextInt();

                if(s==1){
                    union(i,j);
                }
            }
        }
        sc.nextLine();

        int[] plan = new int[m];
        for (int i = 0; i < m; i++) {
            plan[i] = sc.nextInt();
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
