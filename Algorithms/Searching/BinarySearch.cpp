// Binary Search Algorithm

#include <iostream>
using namespace std;

int binarySearch(int arr[],int left,int right,int target) {
    while (left <= right) {
        int mid = left + (right-left) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1;
}

int main() {
    int size,target;
    cin >> size;
    int arr[size];
    for (int i=0;i<size;i++) {
        cin >> arr[i];
    }
    cin >> target;
    cout << binarySearch(arr,0,size-1,target);

    return 0;
}