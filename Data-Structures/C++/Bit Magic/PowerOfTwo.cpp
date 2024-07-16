/* Given an integer n, return true if it is a power of two. Otherwise, return false. */

#include <iostream>
using namespace std;

bool isPowerOfTwo(int n) {
    if(n <= 0){
        return false;
    }
    if((n & (n-1)) == 0){
        return true;
    }
    return false;
}

int main() {
    int n;
    cin >> n;
    cout << isPowerOfTwo(n);
}