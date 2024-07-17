/* Given a non-empty array of integers nums, every element 
appears twice except for one. Find that single one. */

#include <iostream>
using namespace std;

int oddOccurs(int nums[], int n) {
    int ans = 0;
    for (int i=0; i<n; i++) {
        ans = ans ^ nums[i];
    }
    return ans;
}

int main() {
    int n;
    cin >> n;
    int* nums = new int[n];
    for (int i=0; i<n; i++) {
        cin >> nums[i];
    }
    cout << oddOccurs(nums,n);
    return 0;
}