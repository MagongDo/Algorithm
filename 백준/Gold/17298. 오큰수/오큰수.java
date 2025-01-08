
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] x = new int[n];
        Arrays.fill(arr, -1);
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<n;i++){
            x[i] = Integer.parseInt(st.nextToken());
            while(!s.isEmpty() &&x[s.peek()]<x[i]){
                arr[s.pop()] = x[i];
            }
            s.push(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(arr[i]).append(' ');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
