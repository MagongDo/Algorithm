

import java.util.*;

public class Main {
    static int n;
    static String s;
    static List<Integer> num = new ArrayList<>();
    static List<Character> oper_str = new ArrayList<>();
    static int ret = -90000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();       
        s = sc.next();          

        for(int i = 0; i < n; i++){
            if (i % 2 == 0) {
                num.add(s.charAt(i) - '0');
            } else {
                oper_str.add(s.charAt(i));
            }
        }

        DFS(0, num.get(0));

        System.out.println(ret);
    }

    private static int oper(char op, int x, int y) {
        switch (op) {
            case '+': return x + y;
            case '-': return x - y;
            case '*': return x * y;
        }
        return 0;
    }

    private static void DFS(int here, int currentValue) {

        if (here == num.size() - 1) {
            ret = Math.max(ret, currentValue);
            return;
        }

        DFS(here + 1, oper(oper_str.get(here), currentValue, num.get(here + 1)));

        if (here + 2 <= num.size() - 1) {
            int temp = oper(oper_str.get(here + 1), num.get(here + 1), num.get(here + 2));
            DFS(here + 2, oper(oper_str.get(here), currentValue, temp));
        }
    }
}
