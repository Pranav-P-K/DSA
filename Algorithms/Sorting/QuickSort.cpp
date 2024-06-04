// Quick Sort Algorithm

#include <bits/stdc++.h>
using namespace std;

int partition(int arr[],int low,int high) {
    int pivot=arr[high];
    int i=(low-1);       
    for(int j=low;j<=high;j++) {
        if(arr[j]<pivot) {
            i++;
            swap(arr[i],arr[j]);
        }
    }
    swap(arr[i+1],arr[high]);
    return (i+1);
}
           
void quickSort(int arr[],int low,int high) {
    if(low<high) {
        int pi=partition(arr,low,high);
        quickSort(arr,low,pi-1);
        quickSort(arr,pi+1,high);
    }
}
             
 
int main() {
    int size;
    cin >> size;
    int arr[size];
    for (int i=0;i<size;i++) {
        cin >> arr[i];
    }
    quickSort(arr,0,size-1);
    for (int j=0;j<size;j++) {
        cout << arr[j] << " ";
    }
    return 0;
}
// This Code is Contributed By Diwakar Jha
