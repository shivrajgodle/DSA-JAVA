package org.example.DSA.recursion;

public class fibonacci {

    static void withoutRecursionFibonacci(int n){

        int newFibo2 = 0;
        int newFibo1 = 1;

        for(int fibo = 0; fibo < n; fibo++ ){
            int temp = 0;
            temp = newFibo1 + newFibo2;
            System.out.println(temp);
            newFibo2 = newFibo1;
            newFibo1 = temp;
        }
    }

    static int count = 2;
    static void withRecursionFibonacci(int fibo1 , int fibo2){
        if(count <= 10){
            int newFibo = fibo1 + fibo2;
            fibo1 = fibo2;
            fibo2 = newFibo;
            System.out.println(newFibo);
            count+=1;
            withRecursionFibonacci(fibo1,fibo2);

        }else{
            return;
        }
    }


    void main(){
       // withoutRecursionFibonacci(10);
        withRecursionFibonacci(0,1);
    }
}
