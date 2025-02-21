import java.util.Scanner;

public class SecondLargest {


    // public static int SecondLargest(int arr[]) {

    //     int temp;

    //     for (int i = 0; i < arr.length; i++) {

    //         for (int j = i + 1; j < arr.length; j++) {
                
    //             if(arr[i] < arr[j]) {
    //                 temp = arr[j];
    //                 arr[j] = arr[i];
    //                 arr[i] = temp;
    //             }

    //         }
    //     }

    //     System.out.print("Sorted array is:");
    //     for(int num : arr){
    //         System.out.println(num);
    //     }
        
    //     return arr[1];
    // }


    public static int SecondLargest(int arr[]) {

        int largest = arr[0];
        int secondLargest = arr[1];
       
        for(int i=0;i<arr.length;i++){
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            }

            else if(arr[i] > secondLargest && arr[i] != largest){
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.err.println("Enter size of array:-");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter Elements of array:-");

        for(int i = 0; i< size;i++){
            arr[i] = sc.nextInt();
        }


       System.out.println("Second largest element of array is:"+SecondLargest.SecondLargest(arr)); 
    }

}
