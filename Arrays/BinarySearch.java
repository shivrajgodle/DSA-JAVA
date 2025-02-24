import java.util.Scanner;

//Binary search 
//Best case O(1)
//Worst case o(log n)
public class BinarySearch {

    public static int processBinarySearch(int arr[], int targetValue){

        //set high and low values
        int high = arr.length - 1;
        int low = 0;

        //run in loop till low and high gets equal
        while (low <= high) { 
            int midIndex = low + (high - low) / 2;

            //best case at it found at mid position
            if (arr[midIndex] == targetValue) {
                return midIndex;
            }

            //if the target value is low than mid value then assign mid -1 value in high
            if (targetValue < arr[midIndex]) {
                high = midIndex - 1; 
            }

            //if the target value is greater than mid value then assign mid +1 value in low
            if (targetValue > arr[midIndex]) {
                low = midIndex + 1; 
            }

        }

        //if nothing found then assign -1
        return -1;

    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int size = scanner.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter the value one by one:");
        for(int i=0;i<size;i++){    
            arr[i] = scanner.nextInt();
        }

        System.out.println("Your array is:-");
        for (int i=0;i<arr.length;i++) {
            System.out.println(arr[i]+"\t");
        }

        System.out.println("Enter any number to search");
        int searchNum = scanner.nextInt();

        int index = processBinarySearch(arr,searchNum);

        if (index == -1) {
            System.out.println("element not found in array");
        }else{
            System.out.println("element found at "+index+" position in array");
        }
        
     }    
}
