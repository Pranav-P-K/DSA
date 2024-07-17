#include <iostream>
#include <vector>
using namespace std;

pair<int, int> twoOdd(const vector<int>& arr) {
    int xor2 = 0;
    int n = arr.size();
    for (int num : arr) {
        xor2 ^= num;
    }
    int set_bit_no = xor2 & ~(xor2 - 1);
    int x = 0;
    int y = 0;
    for (int num : arr) {
        if (num & set_bit_no) {
            x ^= num;
        } else {
            y ^= num;
        }
    }
    return {x, y};
}

int main() {
    vector<int> arr = {4, 2, 4, 5, 2, 3, 3, 1};
    pair<int, int> result = twoOdd(arr);
    cout << result.first << result.second << endl;
    return 0;
}
