import java.util.Scanner;

//Linear search 
//Best case O(1)
//Worst case o(n)
public class LinearSearch {


    public static int processLinearSearch(int[] arr , int searchNum) {
       int foundIndex = -1;
        for (int i=0;i<arr.length;i++) {
            if (arr[i] == searchNum) {
                foundIndex = i;
            }
        }
        return foundIndex;
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

        int index = processLinearSearch(arr,searchNum);

        if (index == -1) {
            System.out.println("element not found in array");
        }else{
            System.out.println("element found at "+index+" position in array");
        }
        
     }
}
