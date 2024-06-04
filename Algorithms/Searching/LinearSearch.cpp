// Linearch Search Algorithm

#include <iostream>
using namespace std;

int linearSearch(int arr[],int size, int target) {
    for (int i=0;i<size;i++) {
        if (arr[i] == target) {
            return i;
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
    cout << linearSearch(arr,size,target);

    return 0;
}