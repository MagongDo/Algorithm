import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] visited=new int[100001], count=new int[100001];
    static Queue<Integer> queue = new LinkedList<>();
    static void BFS(int n, int m){
        queue.add(n);
        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == m) {
                break;
            }

            int[] nextPositions = {current - 1, current + 1, current * 2};

            for (int next : nextPositions) {
                if (next >= 0 && next < 100001) {
                    if (visited[next] == 0) {
                        visited[next] = visited[current] + 1;
                        count[next] = count[current];
                        queue.add(next);
                    }
                    else if (visited[next] == visited[current] + 1) {
                        count[next] += count[current];
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());

        visited[n]=1;
        count[n] = 1;
        BFS(n, m);
        System.out.println(visited[m] - 1);
        System.out.println(count[m]);


    }
}
