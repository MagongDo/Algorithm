
import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] arr;
    static boolean[] visited;
    public static void DFS(int v){
        visited[v]=true;
        System.out.print(v+" ");
        for(int i=0;i<arr[v].size();i++){
            if(!visited[arr[v].get(i)]){
                DFS(arr[v].get(i));
            }
        }

    }

    public static void BFS(int v){
        Queue<Integer> q = new ArrayDeque<>();

        visited[v]=true;
        q.add(v);
        while(!q.isEmpty()){
            int cur = q.poll();

            System.out.print(cur+" ");
            for(int i=0;i<arr[cur].size();i++){
                if(!visited[arr[cur].get(i)]){

                    q.add(arr[cur].get(i));
                    visited[arr[cur].get(i)]=true;

                }
            }

        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        arr=new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(arr[i]);
        }
        visited=new boolean[n+1];
        DFS(v);
        System.out.println();
        visited=new boolean[n+1];
        BFS(v);


    }
}
