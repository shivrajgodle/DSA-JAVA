import java.util.Scanner;

public class MoveZeroToEnd {

    // 0,1,3,0,7

    public void processArrayToMoveZeroAtEnd(int arr[]){

        int index = 0;
        
        for(int i=0;i<arr.length;i++){
            if (arr[i] != 0) {
               arr[index] = arr[i];
               index++;
            }
           
        }

        while (index < arr.length) { 
            arr[index] = 0;
            index++;
        }

        for (int element : arr) {
            System.out.println(element);
        }


    }


    
    public static void main(String[] args) {
        MoveZeroToEnd m = new MoveZeroToEnd();

        Scanner sc = new Scanner(System.in);
        System.err.println("Enter size of array:-");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter Elements of array:-");

        for(int i = 0; i< size;i++){
            arr[i] = sc.nextInt();
        }


       System.out.println("After moving zero's to end the array is:"); 
       m.processArrayToMoveZeroAtEnd(arr);
    }

}
