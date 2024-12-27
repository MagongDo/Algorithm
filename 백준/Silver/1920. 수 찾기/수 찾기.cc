#include <iostream>
#include <algorithm>
bool binary(int list[], int length, int target) {
    int left = 0;
    int right = length - 1;
    while (left <= right) {
        int mid = (left + right) / 2;
        if (list[mid] == target) {
            return true;
        }
        else if (list[mid] > target) {
            right = mid - 1;
        }
        else {
            left = mid + 1;
        }
    }
    return false;
}
int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    int list_len;
    std::cin >> list_len;
    int list[100001];
    for (int i = 0; i < list_len; ++i) {
        std::cin >> list[i];
    }
    std::sort(list, list + list_len);
    int testcases;
    std::cin >> testcases;
    int testlist[100001];
    int num;
    for (int i = 0; i < testcases; ++i) {
        std::cin >> num;
        if (binary(list, list_len, num)) {
            std::cout << 1 << "\n";
        }
        else {
            std::cout << 0 << "\n";
        }
    }
}