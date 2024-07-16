/* Given an integer n, return an array ans of length n + 1 
such that for each i (0 <= i <= n), ans[i] is the number of 1's 
in the binary representation of i. */

#include <iostream>
#include <vector>
using namespace std;

vector<int> countBits(int n) {
    vector<int> ans;
    for(int i = 0; i<=n; i++) {
        int count = 0;
        int num = i;
        while(num != 0) {
            count += num & 1;
            num >>= 1;
        }
        ans.push_back(count);
    }
    return ans;
}

int main() {
    int n;
    cin >> n;
    vector<int> arr = countBits(n);
    for (int i = 0; i <= n; ++i) {
        cout << arr[i] << " ";
    }
    return 0;
}
