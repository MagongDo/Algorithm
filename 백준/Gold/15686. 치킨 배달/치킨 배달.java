import java.io.*;
import java.util.*;

public class Main{
    static int n,m;
    static List<int[]> homes = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static boolean[] selected;
    static int minAnswer= Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int a = Integer.parseInt(st.nextToken());
                if(a==1){
                    homes.add(new int[]{i,j});
                }
                else if(a==2){
                    chickens.add(new int[]{i,j});
                }
                else continue;
            }
        }
        selected=new boolean[chickens.size()];

        backTracking(0, 0);

        System.out.println(minAnswer);
        
        
        
    }
    public static void backTracking(int dept, int start){
        if(dept==m){
            int minChicken= minDistance();
            minAnswer=Math.min(minChicken,minAnswer);
            return;
        }
        
        for(int i=start;i<chickens.size();i++){
            selected[i]=true;
            backTracking(dept+1,i+1);
            selected[i]=false;
        }
    }
    
    public static int minDistance(){
        int sum=0;
        for(int i=0;i<homes.size();i++){
            int[] home= homes.get(i);
            int min= Integer.MAX_VALUE;
            for(int j=0;j<chickens.size();j++){
                if(selected[j]){
                    int[] chicken=chickens.get(j);
                    min=Math.min(Math.abs(home[0]-chicken[0])+Math.abs(home[1]-chicken[1]),min);
                }
            }
            sum+=min;
        }
        return sum;
    }
}