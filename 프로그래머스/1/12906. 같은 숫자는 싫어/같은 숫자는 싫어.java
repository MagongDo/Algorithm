import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        
        
        
        Stack<Integer> a = new Stack<>();
        
        a.push(arr[0]);
        
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]==arr[i-1]) continue;
            else{
                a.push(arr[i]);
            }
        }
        int[] answer = new int[a.size()];
        for(int i=0;i<a.size();i++){
            answer[i]=a.get(i);
        }

        return answer;
    }
}