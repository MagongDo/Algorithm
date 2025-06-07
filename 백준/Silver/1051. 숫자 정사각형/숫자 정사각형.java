import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        int answer = 1;
        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 1; k < m; k++) {
                    if (j + k < m && i + k < n) {
                        if (arr[i].charAt(j) == arr[i].charAt(j + k) &&
                                arr[i].charAt(j) == arr[i + k].charAt(j) &&
                                arr[i].charAt(j) == arr[i + k].charAt(j + k)) {
                            answer=(k+1)*(k+1);
                            if(max<answer){
                                max=answer;
                            }
                        }
                    }
                }

            }
        }
        System.out.println(max);
    }
}

