import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // HashMap 초기 용량 설정: 기본 로드 팩터 0.75 기준으로 계산
        Map<String, Integer> map = new HashMap<>((int)(n / 0.75f) + 1);

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            if(s.length() < m) {
                continue;
            }
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        // Map의 Entry를 리스트로 변환
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());

        // 커스텀 Comparator를 사용하여 정렬: 빈도수 내림차순, 길이 내림차순, 사전 순 오름차순
        entries.sort((e1, e2) -> {
            // 빈도수 비교
            int freqCompare = e2.getValue().compareTo(e1.getValue());
            if(freqCompare != 0){
                return freqCompare;
            }
            // 길이 비교
            int lenCompare = Integer.compare(e2.getKey().length(), e1.getKey().length());
            if(lenCompare != 0){
                return lenCompare;
            }
            // 사전 순 비교
            return e1.getKey().compareTo(e2.getKey());
        });

        // StringBuilder를 사용하여 출력 문자열 생성
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> entry : entries){
            sb.append(entry.getKey()).append('\n');
        }

        // 최종 출력
        System.out.print(sb.toString());
    }
}
