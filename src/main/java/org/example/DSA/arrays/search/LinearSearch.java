package org.example.DSA.arrays.search;

/*
TIME COMPLEXITY:- O(n)-> Worst Case (The target item is at the very end
of the array, or it does not exist in the array at all.
The algorithm must check all n elements.)

| O(1) -> Best Case (The target item is the very first element
in the array. Only one comparison is needed.)
---------------------------------------
Space Complexity:- O(1)
Cause:- inear search is an in-place algorithm. It only requires a fixed,
constant amount of auxiliary memory to handle a few variables
(like the loop counter index and the target variable).
It does not scale up its memory usage with the size of the input array.
*/
public class LinearSearch {

    static int linearSearch(int[] arr, int target) {
        int n = arr.length;
        for(int i = 0; i < n; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    void main(){
        int arr[] = {13,5,56,15,53,85,10,24};
        int target = 531;
        int result = linearSearch(arr, target);

        if(result != -1){
            System.out.println(target+" value found at location "+result);
        } else {
            System.out.println(target+" value not found");
        }
    }
}
