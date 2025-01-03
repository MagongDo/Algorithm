#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
    string name;
    cin >> name;

    int freq[26] = {0};  // 알파벳 빈도수를 저장할 배열

    // 각 알파벳의 빈도수를 계산
    for (char c : name) {
        freq[c - 'A']++;
    }

    int oddCount = 0;  // 홀수 개수의 문자가 몇 개인지 카운트
    char oddChar = 0;  // 홀수 개수인 문자가 무엇인지 저장
    for (int i = 0; i < 26; i++) {
        if (freq[i] % 2 == 1) {
            oddCount++;
            oddChar = 'A' + i;
        }
    }

    // 홀수 개수의 문자가 2개 이상이면 팰린드롬 불가능
    if (oddCount > 1) {
        cout << "I'm Sorry Hansoo" << endl;
        return 0;
    }

    string half = "";  // 팰린드롬의 절반을 저장할 문자열

    // 알파벳 순서대로 절반 문자열을 구성
    for (int i = 0; i < 26; i++) {
        half += string(freq[i] / 2, 'A' + i);
    }

    // 사전순으로 앞서는 팰린드롬을 만들기 위해 정렬은 이미 되어 있음
    string result = half;

    // 만약 홀수 개수인 문자가 있다면 가운데에 배치
    if (oddCount == 1) {
        result += oddChar;
    }

    // 절반을 뒤집어서 팰린드롬의 뒷부분을 추가
    reverse(half.begin(), half.end());
    result += half;

    // 결과 출력
    cout << result << endl;

    return 0;
}
