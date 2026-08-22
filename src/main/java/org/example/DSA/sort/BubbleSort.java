package org.example.DSA.sort;


/*
TIME COMPLEXITY:- O(n2)-> Worst Case | O(n) -> Best Case (when array in sorted order)
Cause:- Happens when the array is in reverse order,
requiring maximum comparisons and swaps.
---------------------------------------
Space Complexity:- O(1)
Cause:- Requires only a constant amount of extra memory
 for temporary swap variables.
*/
public class BubbleSort {

    static void bubbleSort(int[] arr) {
        int n = arr.length;

        for(int i = 0;i<n;i++){
            for(int j = 0; j < n - i - 1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for(int i=0;i<n;i++){
            System.out.print(arr[i]+",");
        }

    }

    void main(){
        int arr[] = {13,5,56,15,53,85,10,24};
        bubbleSort(arr);
    }
}
