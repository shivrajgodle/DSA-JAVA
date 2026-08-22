package org.example.random;

import java.util.Map;
import java.util.stream.Collectors;

//Input:  "abcabcbb"
//Output: 3
//        "abc" is one valid longest substring.
public class StringManipulation {

    public static void main(String args[]){

        String str = "abcabcbb";

        Map<Character,Long> freq = str.chars()
                .mapToObj((c) -> (char) c)
                .collect(Collectors.groupingBy(c-> c, Collectors.counting()));


        System.out.println(freq);

    }

}
