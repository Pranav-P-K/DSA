/* Given a number N and a bit number K, check if the Kth bit
of N is set or not. A bit is called set if it is 1. */

#include <iostream>
using namespace std;

string isKthBitSet(int n, int k) {
	if (n & (1 << k))
		return "SET";
	else
		return "NOT SET";
}

int main() {
	int n, k;
	cin >> n >> k;
    cout << isKthBitSet(n, k);
	return 0;
}
