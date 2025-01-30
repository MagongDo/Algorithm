import java.util.*;

public class Main {
    static char[][] a = new char[301][301];
    static int n, m, x1, y1, x2, y2;
    static int[][] visited = new int[301][301];
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static Queue<Integer> q = new LinkedList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        y1 = sc.nextInt() - 1;  
        x1 = sc.nextInt() - 1; 
        y2 = sc.nextInt() - 1;  
        x2 = sc.nextInt() - 1;  
        sc.nextLine();
        
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLine().toCharArray();
        }
        
        q.add(1000 * y1 + x1);
        visited[y1][x1] = 1;
        int cnt = 0;
        
        while (a[y2][x2] != '0') {
            cnt++;
            Queue<Integer> temp = new LinkedList<>();
            
            while (!q.isEmpty()) {
                int cur = q.poll();
                int y = cur / 1000;
                int x = cur % 1000;
                
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    
                    if (ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx] != 0) {
                        continue;
                    }
                    
                    visited[ny][nx] = cnt;
                    
                    if (a[ny][nx] != '0') {
                        a[ny][nx] = '0';
                        temp.add(1000 * ny + nx);
                    } else {
                        q.add(1000 * ny + nx);
                    }
                }
            }
            q = temp;
        }
        
        System.out.println(visited[y2][x2]);
        sc.close();
    }
}
