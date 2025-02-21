import java.util.Scanner;

public class FindArraySorted {

    public static boolean isArraySorted(int[] arr) {
        
        boolean isSorted = true;

        for(int i=0;i<arr.length-1;i++){

            if (arr[i+1] < arr[i]) {
                isSorted = false;
            }

        }


        return isSorted;

    }
    
     public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int size = scanner.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter the value one by one:");
        for(int i=0;i<size;i++){    
            arr[i] = scanner.nextInt();
        }

        System.out.println("Array is sorted:-"+FindArraySorted.isArraySorted(arr));
        
    }
        
           
}
