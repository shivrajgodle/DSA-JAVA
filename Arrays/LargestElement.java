
import java.util.Scanner;

public class LargestElement {

    public static int generateLargerNumber(int arr[]){

        int largerstNumber = arr[0];

        for(int i=0;i<arr.length;i++){

            if (arr[i] > largerstNumber) {
                largerstNumber = arr[i];
            }

        }

        return largerstNumber;
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

        System.out.println("Largest Number is:-"+LargestElement.generateLargerNumber(arr));

    }
}
