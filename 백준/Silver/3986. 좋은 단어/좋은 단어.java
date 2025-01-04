
import java.io.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int ret = 0;

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            Stack<Character> stk = new Stack<>();

            for(char a : s.toCharArray()) {
                if(!stk.isEmpty() && stk.peek() == a) {
                    stk.pop();
                } else {
                    stk.push(a);
                }
            }

            if(stk.isEmpty()) {
                ret++;
            }
        }

        // 결과 출력
        System.out.println(ret);
    }
}


