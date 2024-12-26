import java.io.*;
import java.util.*;

public class Main {
    // 유니온 파인드 클래스
    static class UnionFind {
        // 각 원소의 부모를 저장
        private HashMap<String, String> parent;
        // 각 집합의 크기를 저장
        private HashMap<String, Integer> size;

        public UnionFind() {
            parent = new HashMap<>();
            size = new HashMap<>();
        }

        // Find 연산: 경로 압축을 적용하여 루트를 찾음
        public String findSet(String x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                size.put(x, 1);
                return x;
            }

            if (!x.equals(parent.get(x))) {
                parent.put(x, findSet(parent.get(x)));
            }
            return parent.get(x);
        }

        // Union 연산: 두 집합을 합치고, 새로운 집합의 크기를 반환
        public int unionSet(String x, String y) {
            String rootX = findSet(x);
            String rootY = findSet(y);

            if (rootX.equals(rootY)) {
                return size.get(rootX);
            }

            // Union by size: 더 큰 집합을 루트로 설정
            if (size.get(rootX) < size.get(rootY)) {
                parent.put(rootX, rootY);
                size.put(rootY, size.get(rootY) + size.get(rootX));
                return size.get(rootY);
            } else {
                parent.put(rootY, rootX);
                size.put(rootX, size.get(rootX) + size.get(rootY));
                return size.get(rootX);
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

            UnionFind uf = new UnionFind();

            for(int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name1 = st.nextToken();
                String name2 = st.nextToken();

                int networkSize = uf.unionSet(name1, name2);
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
