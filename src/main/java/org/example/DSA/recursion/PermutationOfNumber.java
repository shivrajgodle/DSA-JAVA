package org.example.DSA.recursion;

import java.util.*;
public class PermutationOfNumber {
    public static void main(String[] args) {

        String input = "123";

        char ch[] = input.toCharArray();


        Set<String> set = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();
        int index = 0;
        permutation(ch,index,list);


        System.out.println(" "+list);
    }


    public static void permutation(char[] ch,int index,List<String> list){
        System.out.println("in permutation function index "+index);
        System.out.println("-------------------------");
        if(index == ch.length - 1){
            list.add(new String(ch));
            System.out.println("chalo Tata Bye Bye "+new String(ch));
            return;
        }


        for(int i=index;i<ch.length;i++){
            System.out.println("in for loop "+i);
            System.out.println("++++++++++++++++++++++++++++++");
            swap(ch,index,i);
            permutation(ch,index+1,list);
            swap(ch,index,i);
        }

    }


    public static void swap(char[] ch,int i,int j){
        System.out.println("in swap "+i+" j "+j);
        System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,");
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}