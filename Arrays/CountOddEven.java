import java.util.Scanner;

public class CountOddEven {

    public void CountOddEvenNumber(int[] arr){
        int oddIndex = 0;
        int evenIndex = 0;

        for(int i=0;i<arr.length;i++){

            if (arr[i] % 2 == 0) {
                evenIndex++;
            }else{
                oddIndex++;
            }

        }

        System.out.println("Found following result based array");

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

        System.out.println("Odd number are:-"+oddIndex);
        System.out.println("Even numbers are:-"+evenIndex);
    }

    
     public static void main(String args[]){

        CountOddEven coe = new CountOddEven();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int size = scanner.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter the value one by one:");
        for(int i=0;i<size;i++){    
            arr[i] = scanner.nextInt();
        }

        coe.CountOddEvenNumber(arr);

    }
}
