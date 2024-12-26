

import java.io.*;
import java.util.*;

public class Main {
    // 유니온 파인드 클래스
    static class UnionFind {
        int[] parent;
        int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        // Find 연산: 경로 압축 적용
        public int findSet(int x) {
            if(parent[x] != x) {
                parent[x] = findSet(parent[x]);
            }
            return parent[x];
        }

        // Union 연산: 두 집합을 합치고, 새로운 집합의 크기를 반환
        public int unionSet(int x, int y) {
            int rootX = findSet(x);
            int rootY = findSet(y);

            if(rootX == rootY) {
                return size[rootX];
            }

            // Union by size: 더 큰 집합을 루트로 설정
            if(size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
                return size[rootY];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
                return size[rootX];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 빠른 출력을 위해 BufferedWriter 사용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            int F = Integer.parseInt(br.readLine());

            // 이름을 정수로 매핑하기 위한 HashMap
            HashMap<String, Integer> map = new HashMap<>();
            int idx = 0;

            // 유니온 파인드를 위한 최대 노드 수 예측
            // 각 친구 관계마다 최대 2개의 새로운 사람이 등장할 수 있으므로 2*F로 설정
            UnionFind uf = new UnionFind(2 * F);

            for(int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name1 = st.nextToken();
                String name2 = st.nextToken();

                // 이름을 정수로 매핑
                if(!map.containsKey(name1)) {
                    map.put(name1, idx++);
                }
                if(!map.containsKey(name2)) {
                    map.put(name2, idx++);
                }

                int id1 = map.get(name1);
                int id2 = map.get(name2);

                // Union 연산 후 집합의 크기 반환
                int networkSize = uf.unionSet(id1, id2);
                sb.append(networkSize).append("\n");
            }
        }

        // 결과 출력
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
