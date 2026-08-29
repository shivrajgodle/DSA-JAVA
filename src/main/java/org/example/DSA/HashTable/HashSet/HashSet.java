package org.example.DSA.HashTable.HashSet;

import java.util.*;

public class HashSet {
    static LinkedList<String>[] myHashSet = new LinkedList[10];
    void main() {

        for(int i=0;i < myHashSet.length;i++){
            myHashSet[i] = new LinkedList<>();
        }

        add("shiv");
        add("raj");
        add("ganesh");
        add("manisha");
        add("saurabh");

        for(LinkedList<String> s:myHashSet){
            System.out.println(s);
        }
        System.out.println("Contains Stuart: " + contains("Stuart"));
    }

    public static int hashFunction(String value){
        int sum = 0;
        for(char c: value.toCharArray()){
            sum +=c;
        }
        return sum % 10;
    }

    public static void add(String value){
        int index = hashFunction(value);
        LinkedList<String> bucket = myHashSet[index];
        if(!bucket.contains(value)){
            bucket.add(value);
        }
    }

    public static boolean contains(String value){
        int index = hashFunction(value);
        LinkedList<String> bucket = myHashSet[index];
        return bucket.contains(value);
    }
}
