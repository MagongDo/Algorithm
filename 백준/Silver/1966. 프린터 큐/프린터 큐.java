
import java.util.*;
import java.io.*;

public class Main {
    static class Document {
        int index;      // 문서의 위치
        int priority;   // 문서의 중요도

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        while (testCase-- > 0) {
            int n = sc.nextInt(); // 문서 개수
            int m = sc.nextInt(); // 궁금한 문서의 위치

            Queue<Document> queue = new LinkedList<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < n; i++) {
                int priority = sc.nextInt();
                queue.offer(new Document(i, priority));
                priorityQueue.offer(priority);
            }

            int printOrder = 0;

            while (!queue.isEmpty()) {
                Document current = queue.poll();

                // 현재 문서가 가장 높은 중요도를 갖고 있다면 인쇄
                if (current.priority == priorityQueue.peek()) {
                    printOrder++;
                    priorityQueue.poll(); // 해당 중요도 제거

                    // 궁금한 문서라면 출력
                    if (current.index == m) {
                        System.out.println(printOrder);
                        break;
                    }
                } else {
                    // 중요도가 더 높은 문서가 있다면 뒤로 보냄
                    queue.offer(current);
                }
            }
        }

        sc.close();
    }
}