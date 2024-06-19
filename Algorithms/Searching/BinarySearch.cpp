// Binary Search Algorithm

#include <iostream>
using namespace std;

// Through Iterative method
int binarySearchIterative(int arr[],int left,int right,int target) {
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

// Through Recursive Method
int binarySearchRecursive(int array[], int x, int low, int high) {
  if (high >= low) {
    int mid = low + (high - low) / 2;

    // If found at mid, then return it
    if (array[mid] == x)
      return mid;

    // Search the left half
    if (array[mid] > x)
      return binarySearchRecursive(array, x, low, mid - 1);

    // Search the right half
    return binarySearchRecursive(array, x, mid + 1, high);
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
    cout << binarySearchIterative(arr,0,size-1,target) << endl;
    cout << binarySearchRecursive(arr,target,0,size-1) << endl;

    return 0;
}