package org.example.DSA.HashTable.HashSet;

import java.util.ArrayList;
import java.util.List;

public class NewHashSet {

    void main() {

        SimpleHashSet hashSet = new SimpleHashSet(10);
        hashSet.add("Shivraj");
        hashSet.add("Godle");
        hashSet.print();
        hashSet.remove("Shivraj");
        hashSet.print();
        System.out.println(hashSet.contains("Shivraj"));
        System.out.println(hashSet.contains("Godle"));
    }
}

class SimpleHashSet{

    int size;
    List<List<String>> buckets;

    public SimpleHashSet(int size){
        this.size = size;
        this.buckets = new ArrayList<>(size);
        for(int i=0;i<size;i++){
            buckets.add(new ArrayList<>());
        }
    }


    private int hashCode(String value){
        return value.chars().reduce(0,Integer::sum) % size;
    }


    public void add(String value) {
        int index = hashCode(value);
        List<String> bucket = buckets.get(index);
        if(!bucket.contains(value)){
            bucket.add(value);
        }
    }

    public void remove(String value){
        int index = hashCode(value);
        List<String> bucket = buckets.get(index);
        bucket.remove(value);

    }

    public boolean contains(String value){
        int index = hashCode(value);
        List<String> bucket = buckets.get(index);
        return bucket.contains(value);
    }


    public void print() {
        System.out.println("Hash Set Contents:");
        for (int index = 0; index < buckets.size(); index++) {
            List<String> bucket = buckets.get(index);
            System.out.println("Bucket " + index + ": " + bucket);
        }
    }
}
