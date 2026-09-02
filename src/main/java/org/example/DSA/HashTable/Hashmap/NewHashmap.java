package org.example.DSA.HashTable.Hashmap;

import java.util.ArrayList;
import java.util.List;

public class NewHashmap {

    void main(){
        Hashmap hm = new Hashmap(10);
        hm.put("1","shivraj");
        hm.put("12","Ganesh");
        hm.printHashMap();
        System.out.println(hm.get("1"));
        hm.remove("1");
        hm.printHashMap();

    }

}

class Hashmap{
    private final List<List<Pair>> buckets;

    public Hashmap(int size){
        buckets = new ArrayList<>(size);
        for(int i=0;i<size;i++){
            buckets.add(new ArrayList<>());
        }
    }

    private int hashFunction(String key){
        int numericValue = key.chars()
                .filter(Character::isDigit)
                .map(Character::getNumericValue).sum();
        return numericValue % buckets.size();
    }

    public void put(String key, String value){
        int index = hashFunction(key);
        List<Pair> bucket = buckets.get(index);
        for(Pair pair:bucket){
            if(pair.key.equals(key)){
                pair.value = value;
                return;
            }
        }
       bucket.add(new Pair(key,value));

    }

    public String get(String key){
        int index = hashFunction(key);
        List<Pair> bucket = buckets.get(index);
        for(Pair pair:bucket){
            if(pair.key.equals(key)){
                return pair.value;
            }
        }
        return null;
    }

    public void remove(String key){
        int index = hashFunction(key);
        List<Pair> bucket = buckets.get(index);
        bucket.removeIf(e -> e.key.equals(key));
    }

    public void printHashMap(){
        for (List<Pair> bucket: buckets){
            for(Pair pair:bucket){
                System.out.println(pair.key + " : " + pair.value);
            }
        }
    }

}


class Pair{
    String key;
    String value;

    public Pair(String key, String value){
        this.key = key;
        this.value = value;
    }
}