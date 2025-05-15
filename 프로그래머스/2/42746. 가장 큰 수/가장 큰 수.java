import java.util.*;
class Solution {
    public String solution(int[] numbers) {
         // 1. int[] → String[] 변환
        String[] strNums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNums[i] = String.valueOf(numbers[i]);
        }

        // 2. 정렬 (내림차순: (a + b) > (b + a))
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // 3. 정렬 후 이어붙이기
        StringBuilder sb = new StringBuilder();
        for (String s : strNums) {
            sb.append(s);
        }

        // 4. 예외처리: 앞이 0이면 "0" 리턴 (ex: [0, 0, 0])
        if (sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();

    }
}