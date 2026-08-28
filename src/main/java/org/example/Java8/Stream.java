package org.example.Java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Stream {

    void filterEvenNumber(){
        System.out.println("------------In filterEvenNumber() method started-------------------");

        List<Integer> numbers  = Arrays.asList(2,5,7,8,6,9,31,45,4);

        List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());

        System.out.println("Even numbers are : " + evenNumbers);

        System.out.println("-------------------------------------------------------------------");
    }



    void findMaximumNumber(){
        System.out.println("------------In filterEvenNumber() method started-------------------");

        List<Integer> numbers = Arrays.asList(2,5,7,8,6,9,31,45,4);

        Integer MaxNumber = numbers.stream().max(Integer::compare).orElseThrow();

        System.out.println("Maximum number is : " + MaxNumber);

        System.out.println("-------------------------------------------------------------------");

    }


    void sortNumbersInReverseOrder(){

        System.out.println("------------In sortNumbersInReverseOrder() method started-------------------");

        List<Integer> numbers  = Arrays.asList(2,5,7,8,6,9,31,45,4);

        List<Integer> sortedNumbers = numbers.stream().map(n->n).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        System.out.println("Sorted numbers are : " + sortedNumbers);

        System.out.println("-------------------------------------------------------------------");
    }


    void sortNumbers(){
        System.out.println("------------In sortNumbers() method started-------------------");

        List<Integer> numbers  = Arrays.asList(2,5,7,8,6,9,31,45,4);

        List<Integer> sortedNumbers = numbers.stream().map(n->n).sorted(Comparator.naturalOrder()).collect(Collectors.toList());

        System.out.println("Sorted numbers are : " + sortedNumbers);

        System.out.println("-------------------------------------------------------------------");
    }


    void countStringWithSpecificPrefix(){
        System.out.println("------------In countStringWithSpecificPrefix() method started-------------------");

        List<String> strings = Arrays.asList("apple", "banana", "apricot", "cherry", "avocado");

        long count = strings.stream().filter(s -> s.startsWith("a")).count();

        System.out.println("Count of strings starting with 'a' : " + count);

        System.out.println("-------------------------------------------------------------------");
    }


    void findFirstNonRepeatedCharacterInString(){
        System.out.println("------------In findFirstNonRepeatedCharacterInString() method started-------------------");

        String input = "harihar";

        Optional<Character> firstNonRepeated = input.chars().mapToObj(s -> (char) s).filter(s -> input.indexOf(s) == input.lastIndexOf(s)).findFirst();

        System.out.println(firstNonRepeated.orElse(null));

        System.out.println("-------------------------------------------------------------------");
    }


    void stringUpperCase(){
        System.out.println("------------In stringUpperCase() method started-------------------");

        List<String> strings = Arrays.asList("apple", "banana", "apricot", "cherry", "avocado");

        List<String> uppercaseStrings = strings.stream().map(String::toUpperCase).collect(Collectors.toList());

        System.out.println(uppercaseStrings);
        System.out.println("-------------------------------------------------------------------");
    }


    void sumNumbersInList(){
        System.out.println("------------In sumNumbersInList() method started-------------------");
        List<Integer> numbers = Arrays.asList(2,5,6,2,7,9,1);
        int sum =numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum of numbers in list is : " + sum);

        System.out.println("-------------------------------------------------------------------");
    }

    void checkIfStreamMatchesCondition(){
        System.out.println("------------In checkIfStreamMatchesCondition() method started-------------------");
        List<String> str = Arrays.asList("Java","Stream API", "Python");
        boolean isAnyMatch = str.stream().anyMatch(s -> s.contains("API"));
        System.out.println("Is any string contains 'API' : " + isAnyMatch);
        System.out.println("-------------------------------------------------------------------");
    }

    void findDuplicateNumbersList(){
        System.out.println("------------In findDuplicateNumbersList() method started-------------------");
        List<Integer> numbers = Arrays.asList(2,5,6,2,7,9,9,1);
        Set<Integer> uniqueNumbers = new HashSet<>();
        List<Integer> duplicateNumbers = numbers.stream().filter(n -> !uniqueNumbers.add(n)).collect(Collectors.toList());
        System.out.println("Duplicate numbers in list are : " + duplicateNumbers);
        System.out.println("-------------------------------------------------------------------");
    }

    void groupStringByLength(){
        List<String> names = Arrays.asList("java","mava","cav","horizon","james","mac","shivraj");
        Map<Integer, List<String>> groupedNames = names.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(groupedNames);
        System.out.println("-------------------------------------------------------------------");
    }

    void flattenListOfLists(){
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5,6),
                Arrays.asList(7,8,9)
        );

        List<Integer> flattenLists = listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());

        System.out.println("Flattened list: " + flattenLists);
        System.out.println("-------------------------------------------------------------------");
    }

    void concatenateString(){
        List<String> names = Arrays.asList("hari","harish","harish");
        String concatenatedString = names.stream().reduce("",(a,b) -> a + " " +b).trim();
        System.out.println("Concatenated string: " + concatenatedString);
        System.out.println("-------------------------------------------------------------------");
    }

    void findLongestString(){
        List<String> names = Arrays.asList("hari","harish","harish");
        String longestString = names.stream().max(Comparator.comparingInt(String::length)).get();
        System.out.println("Longest string: " + longestString);
        System.out.println("-------------------------------------------------------------------");
    }

    void findSmallestString(){
        List<String> names = Arrays.asList("hari","harish","harendra","ADASSFDJHFDSJ");
        String smallestString = names.stream().min(Comparator.comparing(String::length)).get();
        System.out.println("Smallest string: " + smallestString);
        System.out.println("-------------------------------------------------------------------");
    }

    void findLongestStringInList(){
        List<String> names = Arrays.asList("hari","harish","harendra","ADASSFDJHFDSJ");
        String longestString = names.stream().reduce((word1,word2) -> word1.length() > word2.length() ? word1 : word2).orElse(null);
        System.out.println("Longest string: " + longestString);
        System.out.println("-------------------------------------------------------------------");
    }

    void countFrequencyOfCharactersInString(){
        String str ="banana";

        Map<Character,Long> characterFrequency = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c-> c, Collectors.counting()));
        System.out.println("Character frequency: " + characterFrequency);
        System.out.println("-------------------------------------------------------------------");
    }

    void parallelStreamToComputeSum(){
        System.out.println("------------In parallelStreamToComputeSum() method started-------------------");
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        long sum = numbers.parallelStream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum of numbers: " + sum);
        System.out.println("-------------------------------------------------------------------");
    }

    void createCustomCollector(){
        System.out.println("------------Question: Create a custom collector to join strings with a delimiter.-------------------");
        List<String> names = Arrays.asList("hari","harish","harish");
        String name = names.stream().collect(Collectors.joining(","));
        System.out.println("Name is:-"+name);
        System.out.println("-------------------------------------------------------------------");
    }

    void removeNullValues(){
        System.out.println("------------Question: Remove null values from a list using filter.-------------------");
        List<String> withNullNames = Arrays.asList("hari",null,"harish",null,"harish");
        List<String> names = withNullNames.stream().filter(Objects::nonNull).collect(Collectors.toList());
        System.out.println("names is:-"+names);
        System.out.println("-------------------------------------------------------------------");
    }

    void calculateAverage(){
        System.out.println("------------Question: Calculate the average of a list of integers.-------------------");
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.println("Average of numbers: " + average);
        System.out.println("-------------------------------------------------------------------");
    }

    void collectMapFromList(){
        System.out.println("Question: Convert a list of strings into a map with the string as the key and its length as the value.");
        List<String> names = Arrays.asList("hari","harish","jacob");
        Map<String,Integer> nameCount = names.stream().collect(Collectors.toMap(n->n, String::length));
        System.out.println("Name count: " + nameCount);
        System.out.println("-------------------------------------------------------------------");
    }

    void partitionNumbersIntoEvenAndOdd(){
        System.out.println("------------Question: Partition a list of numbers into even and odd-------------------");
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Map<Boolean,List<Integer>> partitionedNumbers = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Partitioned numbers: " + partitionedNumbers);
        System.out.println("-------------------------------------------------------------------");
    }

    void findNthLargestNumber(){
        System.out.println("----------Question: Find the 3rd largest element in a listr--------------------");
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer thirdLargestNumber = numbers.stream().sorted(Comparator.reverseOrder()).skip(2).findFirst().orElseThrow();
        System.out.println("Third largest number: " + thirdLargestNumber);
        System.out.println("-------------------------------------------------------------------");
    }

    void findPalindromicString(){
        System.out.println("------------Question: Find all strings that are palindromes in a list.-------------------");
        List<String> strings = Arrays.asList("level","world","madam","java","racecar");
        List<String> palindromicString = strings.stream().filter(s -> s.equals(new StringBuffer(s).reverse().toString())).collect(Collectors.toList());
        System.out.println("Palindromes: " + palindromicString);
        System.out.println("-------------------------------------------------------------------");
    }

    void reverseEachStringInList(){
        System.out.println("------------Question: Reverse each string in a list.-------------------");
        List<String> strings = Arrays.asList("level","world","madam","java","racecar");
        List<String> reversedStrings = strings.stream().map(s -> new StringBuffer(s).reverse().toString()).toList();
        System.out.println("Reversed strings: " + reversedStrings);
        System.out.println("-------------------------------------------------------------------");
    }

    void filterAndMapConvertToList(){
        System.out.println("------------Question: Given a map, filter entries with values greater than 10 and collect keys into a list.-------------------");
        Map<String,Integer> mp = Map.of("A",1,"B",20,"C",30,"D",40);
        List<String> keys = mp.entrySet().stream().filter(m -> m.getValue() > 10).map(m -> m.getKey()).collect(Collectors.toList());
        System.out.println("keys: " + keys);
        System.out.println("-------------------------------------------------------------------");
    }

    void removeDuplicatesWithoutCollectors(){
        System.out.println("------------Question: Remove duplicates from a list without using collectors.-------------------");
        List<Integer> numbers = Arrays.asList(1,1,2,3,4,5,6,7,8,9,10,20,20,6,3,78,8,2,6);
        List<Integer> uniqueNumbers = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println("Unique numbers: " + uniqueNumbers);
        System.out.println("-------------------------------------------------------------------");
    }

    void findTheMostFrequentCharacterInAString(){
        System.out.println("Question: Find the most frequent character in a string.");
        String s = "success";

        char mostFrequent = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                    .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElseThrow();
        System.out.println("Most frequent is:-"+mostFrequent);
    }


    void findCommenBetweenTwoLists(){
        System.out.println("Question: Find the common elements between two lists.");
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> list2 = Arrays.asList(5,6,7,8,9,10,11,12,13,14,15);
        List<Integer> commonElements = list1.stream().filter(list2::contains).collect(Collectors.toList());
        System.out.println("Common elements: " + commonElements);
    }

    void findSumOfEvenNumbersSquare(){
        System.out.println("Question: Calculate the sum of squares of all even numbers in a list.");
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int sum = numbers.stream().filter(n -> n % 2 == 0).mapToInt(n -> n * n).sum();
        System.out.println("Sum of squares of even numbers: " + sum);
    }

    void partitionStringByPalindromAndNonPalindrom(){
        System.out.println("Question: Partition strings into palindromes and non-palindromes.");
        List<String> names = Arrays.asList("radar","jhon","nayan","madam","shon","shiv");

        Map<Boolean,List<String>> partitionList = names.stream().collect(Collectors.partitioningBy(n -> n.equals(new StringBuffer(n).reverse().toString())));
        System.out.println("Partition list by palindrom and non-palindrom: " + partitionList);
        System.out.println("-------------------------------------------------------------------");
    }

    void skipAndLimitElements(){
        System.out.println("Question: Skip the first 3 elements and limit the result to the next 2.");
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> result = numbers.stream().skip(3).limit(2).collect(Collectors.toList());
        System.out.println("Result: " + result);
        System.out.println("-------------------------------------------------------------------");
    }


    void findLongestWordFromSentence(){
        System.out.println("Question: Find the longest word in a sentence using Streams.");

        String s = "i am listening coke studio music";

        String longestWord = Arrays.stream(s.split(" ")).max(Comparator.comparingInt(String::length)).orElse(null);
        System.out.println("longestWord is:-"+longestWord);
    }


    void computeCartesianProductOfTwoLists(){
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(4,5);

        List<String> cartesianProduct = list1.stream().flatMap(i -> list2.stream().map(j-> "("+i+","+j+")")).collect(Collectors.toList());
        System.out.println("Cartesian product: " + cartesianProduct);
    }

    void findTopNHighestScoringStudents(){
        System.out.println("-----------Question: From a list of students, find the top 3 by score.-------------");

        List<student> students = Arrays.asList(
                new student("shivraj",90),
                new student("Boyed",70),
                new student("Randel",95),
                new student("Tabitha",80),
                new student("Victor",88)
                );
        List<String> names = students.stream()
                .sorted(Comparator.comparingInt((student s) -> s.score).reversed())
                .limit(3).map(s -> s.name)
                .collect(Collectors.toList());
        System.out.println("Names of top 3 students: " + names);
        System.out.println("-------------------------------------------------------------------");
    }


    void groupStringByFirstCharector(){
        System.out.println("------------Question: Group a list of strings by their first character.-----------");
        List<String> strings = Arrays.asList("apple","angoor", "banana", "cherry", "date", "elderberry");
        Map<Character,List<String>> groupedStrings = strings.stream().collect(Collectors.groupingBy((s) -> s.charAt(0)));
        System.out.println("Grouped strings: " + groupedStrings);
        System.out.println("-------------------------------------------------------------------");
    }

    void customReduceConcateString(){
        System.out.println("------------Question: Concatenate strings in reverse order using reduce.-----------");
        List<String> strings = Arrays.asList("Stream", "API", "is", "awesome");
        String result = strings.stream().reduce((s1,s2) -> s2 + " " + s1).orElse("");
        System.out.println("Result: " + result);
        System.out.println("-------------------------------------------------------------------");
    }

    void collectNestedMapByGrouping(){
        System.out.println("------------Question: Group employees by department and then by age.-----------");

        List<Employee> employees = Arrays.asList(
                new Employee("Shivraj","Cyber security", 29,60000),
                new Employee("Ram","Cyber security", 29,800456),
                new Employee("Boyed","Post Office", 54,56773),
                new Employee("Randel","Gymnasium", 33,46762),
                new Employee("Tabitha","Bank", 49,76435),
                new Employee("Victor","Cyber security", 48,100034)
        );

            Map<String, Map<Integer, List<String>>> groupedEmployees = employees.stream()
                    .collect(Collectors.groupingBy(e -> e.department,Collectors.groupingBy(e -> e.age ,Collectors.mapping(e -> e.name, Collectors.toList()))));
            System.out.println("Grouped employees: " + groupedEmployees);
            System.out.println("-------------------------------------------------------------------");
    }


    void findTheWordWhichHasMaximumVowels(){
        System.out.println("----------Find the word with the most vowels in a list.------------");
        List<String> words = Arrays.asList("stream", "java", "programming", "awesome");

        String result = words.stream().max(Comparator.comparingInt(w -> (int) w.chars().filter(c -> "aeiou".indexOf(c) != -1).count())).orElse(null);
        System.out.println("Result: " + result);
        System.out.println("-------------------------------------------------------------------");
    }

    void generateFibonacciSeries(){
        int n = 10;
        List<Integer> numbers = java.util.stream.Stream.iterate(new int[]{0,1} , arr -> new int[]{arr[1], arr[0] + arr[1]})
                .limit(n)
                .map(arr -> arr[0])
                .collect(Collectors.toList());
        System.out.println("Fibonacci series: " + numbers);
        System.out.println("-------------------------------------------------------------------");
    }

    void findEmployeeWithHighestSalaryInDepartment(){

        List<Employee> employees = Arrays.asList(
                new Employee("Shivraj","Cyber security", 29,60000),
                new Employee("Ram","Cyber security", 29,800456),
                new Employee("Boyed","Post Office", 54,56773),
                new Employee("Randel","Gymnasium", 33,46762),
                new Employee("Tabitha","Bank", 49,76435),
                new Employee("Victor","Cyber security", 48,100034)
        );

        Map<String,Employee> groupedEmployee = employees
                .stream()
                .collect(Collectors.groupingBy(e -> e.department, Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingDouble(e -> e.salary)),
                        Optional::get)
                ));
        System.out.println("Grouped employees: " + groupedEmployee);
        System.out.println("-------------------------------------------------------------------");
    }

    void groupWordsByLengthAndSortThem(){
        List<String> words = Arrays.asList("java","python","jhon","cobra","shama","grapes","apples");

        Map<Integer, List<String>> groupWords = words.stream()
                .collect(Collectors.groupingBy(String::length,
                        Collectors.collectingAndThen(Collectors.toList(),
                                list -> list.stream()
                                        .sorted()
                                        .collect(Collectors.toList()))));
        System.out.println("Grouped words: " + groupWords);
        System.out.println("-------------------------------------------------------------------");
    }

    void calculateProductOfNumbers(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        long product = numbers.stream().reduce(1,(a,b) ->  a * b);
        System.out.println("Product of numbers: " + product);
        System.out.println("-------------------------------------------------------------------");
    }

    void removeDuplicates(){
        String input = "aabbccdd";
        String nonDuplicate = input.chars().distinct().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
        System.out.println("nonDuplicate string: " + nonDuplicate);
    }

    void removeDuplicatesManual(){
        String input = "aabbccdd";
        Set<Character> seen = new LinkedHashSet<>();
        for(char cd: input.toCharArray()){
            seen.add(cd);
        }

        StringBuilder sb = new StringBuilder();
        for(char c: seen){
            sb.append(c);
        }
        System.out.println("removeDuplicatesManual is:-"+sb.toString());
    }

    void ReverseStringJava8(){
        String input = "shivraj";

        String reversed = input.chars().mapToObj(c -> String.valueOf((char) c)).reduce("",(a,b) -> b + a);
        System.out.println("ReverseStringJava8 is:-"+reversed);
    }

    void SortInReverseOrderThenReverseString(){
        // Input
        // "abcdefgh","abcdefghijkl","abcdef","abcdefghijklmnop","abcd"
        // Output
        // "ponmlkjihgfedcba","lkjihgfedcba","hgfedcba","fedcba","dcba"
        List<String> input = Arrays.asList("abcdefgh","abcdefghijkl","abcdef","abcdefghijklmnop","abcd");

        List<String> decendingReversed = input.stream().sorted(Comparator.comparingInt(String::length).reversed()).map(e-> new StringBuilder(e).reverse().toString()).toList();

        decendingReversed.forEach(System.out::println);
    }

    void findSecondHighestNumberFromList(){
        List<Integer> list = Arrays.asList(10, 20, 35, 50, 50, 22);
        list.forEach(e -> System.out.println(e+" "));

        //First Approach
        Integer sorted = list.stream().sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst().get();

        System.out.print("sorted number is:-"+sorted);

        //Second Approach
       Optional<Integer> secondHighest = list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
       secondHighest.ifPresent(e -> System.out.println("secondHighest is:-"+e));
    }

    public void findAllDuplicateElementsInList(){
        List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        Set<Integer> set = new HashSet<>();
        List<Integer> duplicates = list.stream().filter(e -> !set.add(e)).collect(Collectors.toList());
        duplicates.forEach(e -> System.out.print(e+" "));
    }

    public void countOccuranceOfEachCharector(){
        String input = "gainjava";

        //First Approach
        Map<Character, Long> characterIntegerMap = input.chars().mapToObj(c ->(char) c).collect(Collectors.groupingBy(Character::charValue,Collectors.counting()));

        for(Map.Entry<Character, Long> entry:characterIntegerMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        System.out.println("-------------");
        //Second Approach
       Map<String,Long> charCount = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        for(Map.Entry<String,Long> entry:charCount.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

    public void groupEmployeesbyDepartment(){
        List<Employee> employees = List.of(
                new Employee("shivraj","IT",30,25000),
                new Employee("sam","Sales",45,21000),
                new Employee("jane","HR",28,22000),
                new Employee("Jhon","IT",38,27000),
                new Employee("jane","HR",28,22000),
                new Employee("jane","HR",28,22000)
                );

       Map<String,List<Employee>> groupEmployeesByDept = employees.stream().distinct().collect(Collectors.groupingBy(Employee::getDepartment));

        for(Map.Entry<String,List<Employee>> entry:groupEmployeesByDept.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

    public static void main(String[] args) {
        Stream s = new Stream();

        //s.filterEvenNumber();
        //s.findMaximumNumber();
        //s.sortNumbersInReverseOrder();
        //s.sortNumbers();
        //s.countStringWithSpecificPrefix();
        //s.findFirstNonRepeatedCharacterInString();
        //s.stringUpperCase();
        //s.sumNumbersInList();
        //s.checkIfStreamMatchesCondition();
        //s.findDuplicateNumbersList();
        //s.groupStringByLength();
        //s.flattenListOfLists();
        //s.concatenateString();
        //s.findLongestString();
        //s.findSmallestString();
        //s.findLongestStringInList();
        //s.countFrequencyOfCharactersInString();
        //s.parallelStreamToComputeSum();
        //s.createCustomCollector();
        //s.removeNullValues();
        //s.calculateAverage();
       // s.collectMapFromList();
//        s.partitionNumbersIntoEvenAndOdd();
        //s.findNthLargestNumber();
        //s.findPalindromicString();
        //s.reverseEachStringInList();
        //s.filterAndMapConvertToList();
        //s.removeDuplicatesWithoutCollectors();
        //s.findTheMostFrequentCharacterInAString();
        //s.findCommenBetweenTwoLists();
        //s.findSumOfEvenNumbersSquare();
        //s.partitionStringByPalindromAndNonPalindrom();
        //s.skipAndLimitElements();
        //s.findLongestWordFromSentence();
        //s.computeCartesianProductOfTwoLists();
        //s.findTopNHighestScoringStudents();
        //s.groupStringByFirstCharector();
        //s.customReduceConcateString();
        //s.collectNestedMapByGrouping();
//        s.collectNestedMapByGrouping();
        //s.findTheWordWhichHasMaximumVowels();
        //s.generateFibonacciSeries();
        //s.findEmployeeWithHighestSalaryInDepartment();
        //s.groupWordsByLengthAndSortThem();
//        s.calculateProductOfNumbers();
      //  s.removeDuplicates();
        //s.removeDuplicatesManual();
        //s.ReverseStringJava8();
        //s.SortInReverseOrderThenReverseString();
        //s.findSecondHighestNumberFromList();
        //s.findAllDuplicateElementsInList();
        //s.countOccuranceOfEachCharector();
        s.groupEmployeesbyDepartment();
    }
}

class student {
    String name;
    Integer score;

    student(String name,Integer score){
        this.name = name;
        this.score = score;
    }
}


class Employee {
    String name;
    String department;
    Integer age;
    double salary;

    Employee(String name, String department, Integer age, double salary){
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return "Employee{" + "name='" + name + '\'' + ", department='" + department + '\'' + ", age=" + age + ", salary=" + salary + '}';
    }
}