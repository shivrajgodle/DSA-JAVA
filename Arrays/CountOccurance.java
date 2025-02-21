
import java.util.Scanner;

public class CountOccurance {

    public static int FindOccurance(int number , int arr[]){

        int count = 0;

        for(int i=0;i<arr.length;i++){
            if (arr[i] == number) {
               count++; 
            }
        }


        return count;
    }

    
    public static void main(String args[]){
        int arr[] = {44,5,1,56,5,6,66,1,4,44,4,56};
        Scanner sc = new Scanner(System.in);

        System.out.println("We have following array of numbers:");

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

        System.out.println("Enter any number to find the occurance in the array:");
        int number  = sc.nextInt();


        System.out.println("Number of times it occured in array is:"+CountOccurance.FindOccurance(number, arr));
    }
}
