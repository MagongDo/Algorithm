import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 포켓몬 이름을 저장할 배열과 이름-번호 매핑을 위한 HashMap 생성
        String[] pockets = new String[n+1]; // 1번부터 시작하기 위해 n+1
        HashMap<String, Integer> nameToNumber = new HashMap<>(n);

        for(int i=1;i<=n;i++){
            String name = br.readLine();
            pockets[i] = name;
            nameToNumber.put(name, i);
        }

        for(int i=0;i<m;i++){
            String s = br.readLine();

            // 첫 글자가 숫자인지 확인
            if(Character.isDigit(s.charAt(0))){
                int num = Integer.parseInt(s);
                sb.append(pockets[num]).append("\n");
            }
            else{
                sb.append(nameToNumber.get(s)).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
