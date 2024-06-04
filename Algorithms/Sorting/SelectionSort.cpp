// Selection SOrt Algorithm

#include <iostream>
using namespace std;

void selectionSort(int arr[],int size) {
    for (int i=0;i<size-1;i++) {
        int minIndex = i;
        for (int j=i+1;j<size;j++) {
            // change > or < this wrt order
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
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
    selectionSort(arr,size);
    for (int j=0;j<size;j++) {
        cout << arr[j] << " ";
    }
    return 0;
}