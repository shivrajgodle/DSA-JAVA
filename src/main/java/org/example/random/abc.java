package org.example.random;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class abc {

    void firstNonRepeatingCharector(){

        String input = "harihar";

        input.chars().mapToObj(s -> (char) s)
                .filter((s) -> input.indexOf(s) == input.lastIndexOf(s))
                .findFirst()
                .ifPresent(s -> System.out.println("First non-repeating character: " + s));

    }



    void removeDuplicates(){

       List<Integer> list = Arrays.asList(1,1,2,2,3,4,4);

        Set<Integer> set = new HashSet<>();

        List<Integer> removed = list.stream().filter(s -> set.add(s)).collect(Collectors.toList());

        System.out.println("removed:-"+removed);

    }

    public static void main(String[] args) {
        abc a = new abc();
        //a.firstNonRepeatingCharector();
        a.removeDuplicates();
    }
}






