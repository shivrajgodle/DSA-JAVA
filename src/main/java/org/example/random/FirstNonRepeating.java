package org.example.random;

import java.util.Optional;

public class FirstNonRepeating {

    public static void main(String[] args) {

        String input = "neelansh";
        Optional<Character> firstNonRepeated = input.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> input.indexOf(c) == input.lastIndexOf(c))
                .findFirst();
        System.out.println(firstNonRepeated.orElse(null));

    }
}



