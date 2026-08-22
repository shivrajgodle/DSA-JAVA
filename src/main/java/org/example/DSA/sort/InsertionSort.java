package org.example.DSA.sort;

public class InsertionSort {

    static void insertionSort(int arr[]){
        int n = arr.length;
        for(int i =1;i<n;i++){
            int insertIndex = i;
            int currentValue = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > currentValue){
                arr[j + 1] = arr[j];
                insertIndex = j;
                j--;
            }
            arr[insertIndex] = currentValue;
        }

        for(int i=0;i<n;i++){
            System.out.print(arr[i]+", ");
        }

    }

    void main(){
        int arr[] = {64, 34, 25, 12};
        insertionSort(arr);
    }
}
