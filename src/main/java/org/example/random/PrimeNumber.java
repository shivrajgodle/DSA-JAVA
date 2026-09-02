package org.example.random;

public class PrimeNumber {

    public boolean isPrime(int num) {
        if(num <= 1){
            return false;
        }

        for(int i=2;i<Math.sqrt(num);i++){
            if(num % i == 0 ){
                return false;
            }
        }
        return true;
    }


    void main() {
        int range = 10;

        for(int i=0;i<range;i++){
            if(isPrime(i)){
                System.out.println(i+" is prime number");
            }
        }
    }

}
