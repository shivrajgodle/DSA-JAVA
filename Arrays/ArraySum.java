import java.util.*;

public class ArraySum {

    public static int sum(int arr[]){

        int totalSum = 0;

        for(int i=0;i<arr.length;i++){
            totalSum += arr[i];
        }

        return totalSum;
    }
    

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        System.err.println("Enter size of array:-");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter Elements of array:-");

        for(int i = 0; i< size;i++){
            arr[i] = sc.nextInt();
        }


       System.out.println("Sum of array is:"+ArraySum.sum(arr)); 
    }


    
}
