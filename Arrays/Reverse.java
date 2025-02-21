import java.util.Scanner;

public class Reverse {


    public static int[] generateReverseArray(int arr[]){

        int temp[] = new int[arr.length];

        for(int i = arr.length - 1;i >= 0;i--){
            temp[arr.length - i - 1] = arr[i];
        }
        return  temp;
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
        
        int reversedArray[] = Reverse.generateReverseArray(arr);

        System.out.println("Reverse Array is:-"+reversedArray);

    }
}
