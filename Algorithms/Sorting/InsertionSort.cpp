// Insertion Sort Algorithm

#include <iostream>
using namespace std;

void insertionSort(int arr[], int size) {
    for (int i = 1; i < size; i++) {
        int key = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
    }
}

int main() {
    int size;
    cin >> size;
    int arr[size];
    for (int i=0;i<size;i++) {
        cin >> arr[i];
    }
    insertionSort(arr,size);
    for (int j=0;j<size;j++) {
        cout << arr[j] << " ";
    }
    return 0;
}