package org.example.DSA.sort;

/*
TIME COMPLEXITY:- O(n2)-> Worst Case
Cause:- Elements are in a random order, requiring the standard number of comparisons.
---------------------------------------
Space Complexity:- O(1)
Cause:- Selection sort is an in-place sorting algorithm.
It rearranges the elements directly within the original array.
It only requires a few extra memory units to hold temporary variables.
*/
public class SelectionSort {

    static void selectionSort(int arr[]){

        int n = arr.length;
        for(int i=0;i<n;i++){
            int min_value = i;
            for(int j=i+1;j<n;j++){
                if(arr[j] < arr[min_value]){
                    min_value = j;
                }
            }
            int temp = arr[min_value];
            arr[min_value] = arr[i];
            arr[i] = temp;
        }

        for(int i=0;i<n;i++){
            System.out.print(arr[i]+", ");
        }

    }

    void main(){
        int arr[] = {13,5,56,15,53,85,10,24};
        selectionSort(arr);
    }
}
