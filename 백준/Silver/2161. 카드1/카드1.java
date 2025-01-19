
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i+1);
        }
        int count=0;
        while (!queue.isEmpty()) {
            if(count%2==0){
                System.out.print(queue.poll()+" ");
            }
            else{
                int current = queue.poll();
                queue.add(current);
            }
            count++;
        }

    }
}
