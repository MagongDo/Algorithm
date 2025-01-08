
import java.io.*;
import java.util.*;

public class Main {


    static List<List<Integer>> arr = new ArrayList<>();
    static int count = 0, current = 0, k;

    static int DFS(int node) {
        int childCount = 0;
        for (int child : arr.get(node)) {
            if (child == k) continue;  
            childCount++;
            DFS(child);
        }
        if (childCount == 0) {
            count++;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x == -1) {
                current = i;
                continue;
            }
            arr.get(x).add(i);
        }
        k = Integer.parseInt(br.readLine());

        if (k == current) {
            System.out.println(0);
            return;
        }

        DFS(current);
        System.out.println(count);
    }
}

