// Bubble Sorting Algorithm

#include <iostream>
using namespace std;

void bubbleSort(int arr[],int size) {
    for (int i=0;i<size-1;i++) {
        for (int j=0;j<size-i-1;j++) {
            // change > or < this wrt order
            if (arr[j] > arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
}

int main() {
    int size;
    cin >> size;
    int arr[size];
    for (int i=0;i<size;i++) {
        cin >> arr[i];
    }
    bubbleSort(arr,size);
    for (int j=0;j<size;j++) {
        cout << arr[j] << " ";
    }

    return 0;
}