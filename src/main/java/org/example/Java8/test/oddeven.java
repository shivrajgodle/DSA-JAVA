package org.example.Java8.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

//3rd highest even number from list with distinct elements using java 8
//        1,2,5,7,9,6,6,4,2,8,7,3,3,10
public class oddeven {


    static void handleOddEven(){
       List<Integer> list = Arrays.asList(1,2,5,7,9,6,6,4,2,8,7,3,3,10);
       Integer num =list.stream().map(e -> e).filter(e -> e % 2 == 0)
               .collect(Collectors.toList())
               .stream().sorted(Comparator.reverseOrder()).distinct().skip(2).findFirst().orElse(null);

        System.out.print("third highest num is:-"+num);

    }

    void main(){
        handleOddEven();
    }
}
