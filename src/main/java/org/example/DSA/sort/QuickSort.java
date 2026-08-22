package org.example.DSA.sort;

/*
TIME COMPLEXITY:- O(n²) -> Worst Case (Pivot splits the array highly unbalanced (e.g., 1 and n-1 elements).)
| 𝑂(𝑛log𝑛) -> Best Case (Pivot splits the array balanced enough over random iterations.)

---------------------------------------
Space Complexity:- (O(log n))
Cause:- Quick Sort rearranges elements directly within the original array, its auxiliary
data storage space is O(1) (constant).
However, it requires extra memory for the recursion call stack
*/
public class QuickSort {

    public static void main(String[] args) {
        int[] myArray = {64, 34, 25, 12, 22, 11, 90, 5};
        quicksort(myArray, 0, myArray.length - 1);

        System.out.print("Sorted array: ");
        for (int value : myArray) {
            System.out.print(value + " ");
        }
    }

    public static void quicksort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quicksort(array, low, pivotIndex - 1);
            quicksort(array, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}
