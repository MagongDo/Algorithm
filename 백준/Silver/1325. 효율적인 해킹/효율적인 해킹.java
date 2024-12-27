import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] graph;
    static int[] visited;
    static int currentId = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력: N (컴퓨터 수), M (신뢰 관계 수)
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 그래프 초기화 (1번부터 N번까지)
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 신뢰 관계 입력: A B (A가 B를 신뢰)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[B].add(A); // B에서 A로 향하는 간선
        }

        // 방문 배열 초기화
        visited = new int[N + 1];

        // 각 컴퓨터에서 BFS 수행하여 해킹 가능한 컴퓨터 수 계산
        int[] counts = new int[N + 1];
        int max = 0;

        for (int i = 1; i <= N; i++) {
            counts[i] = bfs(i);
            if (counts[i] > max) {
                max = counts[i];
            }
        }

        // 최대값을 가지는 컴퓨터 번호들을 수집
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (counts[i] == max) {
                sb.append(i).append(" ");
            }
        }

        // 결과 출력
        System.out.println(sb.toString().trim());
    }

    // BFS 메서드: 시작 노드에서 도달 가능한 노드의 수를 반환
    static int bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = currentId;
        int count = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph[current]) {
                if (visited[neighbor] != currentId) {
                    visited[neighbor] = currentId;
                    queue.offer(neighbor);
                    count++;
                }
            }
        }

        currentId++;
        return count;
    }
}
