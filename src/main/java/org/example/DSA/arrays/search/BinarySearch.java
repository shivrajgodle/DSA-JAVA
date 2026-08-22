package org.example.DSA.arrays.search;

public class BinarySearch {

    private int binarySearch(int[] arr, int target) {
      int left = 0;
      int right = arr.length - 1;

      while(left<=right){
          int mid = (left + right) / 2;
          if(arr[mid] == target){
              return mid;
          }

          if(arr[mid] < right){
            left = mid + 1;
          } else {
            right = mid - 1;
          }
      }
      return -1;
    }

    void main(){
        int arr[] = {1,3,4,5,6,7,8,9};
        int target = 7;
        int result = binarySearch(arr, target);

        if(result != -1){
            System.out.println(target+" value found at location "+result);
        } else {
            System.out.println(target+" value not found");
        }
    }


}
