import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] ret = new ArrayList[14];
    static int n;
    static int[] a = new int[1030];
    public static void go(int s, int e, int level) {
        if (s > e) return;
        if (s == e) {
            ret[level].add(a[s]);
            return;
        }
        int mid = (s + e) / 2;
        ret[level].add(a[mid]);
        go(s, mid - 1, level + 1);
        go(mid + 1, e, level + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int _end = (int)Math.pow(2, n) - 1;
        for(int i = 0; i < _end; i++) {
            a[i] = sc.nextInt();
        }
        for(int i = 1; i <= n; i++) {
            ret[i] = new ArrayList<Integer>();
        }
        go(0, _end - 1, 1); 
        for(int i = 1; i <= n; i++) {
            for(int num : ret[i]) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
