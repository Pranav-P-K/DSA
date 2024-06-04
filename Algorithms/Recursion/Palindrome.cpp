// Palindrom check using recursion

#include <bits/stdc++.h>
#include <iostream>
using namespace std;

bool isPalindrome(string str, int left, int right) {
    if (left==right) return true;
    if (str[left] != str[right]) return false;
    if (left < right+1) return isPalindrome(str,left+1,right-1);
    return true;
}

int main() {
    string str;
    getline(cin,str);

    if (isPalindrome(str,0,str.length()-1)) {
        cout << "Palindrome";
    } else {
        cout << "Not a Palindrome";
    }
    return 0;
}