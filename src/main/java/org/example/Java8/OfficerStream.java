package org.example.Java8;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class OfficerStream {

    public static void getNameOfEmployeesInITDepartment(List<Officer> officers){
        List<String> names = officers.stream().filter(e -> e.department().equals("IT")).map(e -> e.name()).collect(Collectors.toList());
        names.forEach(System.out::println);
    }

    public static void getEmployeesGreaterThanSomethingInDecendingOrder(List<Officer> officers){
        List<Officer> officersGreaterThanSomething =
                officers
                        .stream()
                        .sorted(Comparator.comparingDouble(Officer::salary).reversed()).filter(e ->e.salary() > 70000).collect(Collectors.toList());



        officersGreaterThanSomething.forEach(System.out::println);
    }


    public static void countEmployeesByDepartment(List<Officer> officers){
     Map<String,Long> mp = officers.stream().collect(Collectors.groupingBy(Officer::department,Collectors.counting()));
     mp.forEach((k,v) -> System.out.println(k + " : " + v));
    }

    public static void getTotalSalaryExpenseForCompany(List<Officer> officers){
       Double totalSalary = officers.stream().mapToDouble(Officer::salary).sum();
        System.out.println("totalSalary is:-"+totalSalary);
    }

    public static void getAverageSalaryOfCompany(List<Officer> officers){
    // Double avarageSalary = officers.stream().collect(Collectors.averagingDouble(Officer::salary));
        Double avarageSalary = officers.stream().mapToDouble(e -> e.salary()).average().orElse(0.0);
      System.out.println("avarageSalary is:-"+avarageSalary);
    }

    private static void groupEmployeeNamesByDepartment(List<Officer> officers) {
        Map<String,List<String>> mp =  officers.stream().collect(Collectors.groupingBy(Officer::department,Collectors.mapping(Officer::name,Collectors.toList())));
        mp.forEach((k,v) -> System.out.println(k + " : " + v));
    }

    private static void groupByDepartmentThenGenderAndCount(List<Officer> officers) {
       Map<String,Map<String,Long>> mp = officers.stream()
               .collect(Collectors.groupingBy(Officer::department,Collectors.groupingBy(Officer::gender,Collectors.counting())));
        mp.forEach((k,v) -> System.out.println(k + " : " + v));
    }

    private static void getAverageSalaryPerDepartment(List<Officer> officers) {
      Map<String,Double> mp = officers.stream().collect(Collectors.groupingBy(Officer::department,Collectors.averagingDouble(Officer::salary)));
        mp.forEach((k,v) -> System.out.println(k + " : " + v));
    }

    private static void getHighestPaidEmployeeInEachDepartment(List<Officer> officers) {
       Map<String, Optional<Officer>> mp = officers.stream().collect(Collectors.groupingBy(Officer::department,Collectors.maxBy(Comparator.comparingDouble(Officer::salary))));
       mp.forEach((k,v) -> System.out.println(k + " : " + v));
    }

    private static void topEarnerPerDepartment(List<Officer> officers) {
        Map<String, Officer> mp = officers.stream().collect(Collectors.groupingBy(Officer::department,Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Officer::salary)),Optional::get)));
        mp.forEach((k,v) -> System.out.println(k + " : " + v));
    }

    private static void getEmployeeNamesWhoJoinedAfter2018InEachDepartment(List<Officer> officers) {
        Map<String, List<String>> mp = officers.stream().filter(e-> e.joiningDate().isAfter(LocalDate.of(2018,12,31))).collect(Collectors.groupingBy(Officer::department,Collectors.mapping(Officer::name,Collectors.toList())));
        mp.forEach((k,v) -> System.out.println(k + " : " + v));
    }

    private static void getEmployeeBySalaryWithPartitioning(List<Officer> officers) {
        Map<Boolean,List<Officer>> mp = officers.stream().collect(Collectors.partitioningBy(e -> e.salary() >= 82000));
        mp.forEach((k,v) -> System.out.println(k + " : " + v));
    }

    private static void getPartitionByAgeAndCountByDepartment(List<Officer> officers) {
        Map<Boolean,Map<String,Long>> hm = officers.stream().collect(Collectors.partitioningBy(e -> e.age() > 30,Collectors.groupingBy(Officer::department,Collectors.counting())));
        hm.forEach((k,v) -> System.out.println(k + " : " + v));
    }

    private static void getSortByAgeAndNullShouldBeLast(List<Officer> officers) {
      List<Officer> sortedByManager = officers.stream().sorted(Comparator.comparing(Officer::managerId,Comparator.nullsLast(Comparator.naturalOrder()))).collect(Collectors.toList());
      sortedByManager.forEach(System.out::println);
    }

    private static void getEmployeesByDepartmentInAscendingAndSalaryInDecendingOrder(List<Officer> officers) {
      List<Officer> officer = officers.stream()
              .sorted(Comparator.comparing(Officer::department)
                      .thenComparing(Comparator.comparing(Officer::salary).reversed())).toList();

      officer.forEach(System.out::println);
    }

    private static void getTotalSalary(List<Officer> officers) {
      Double total = officers.stream().mapToDouble(Officer::salary).reduce(0.0,Double::sum);
      System.out.println("total is:-"+total);
    }

    private static void getHighestPaidEmployeeUsingReduce(List<Officer> officers) {
       Optional<Officer> highestPaid = officers.stream().reduce((e1,e2) -> e1.salary() > e2.salary() ? e1 : e2);
        System.out.println(highestPaid);
    }

    private static void getNthHighestPaidEmployeePerDepartment(List<Officer> officers) {
        int n = 2;
       Map<String,List<Officer>> mp =  officers.stream()
               .collect(Collectors.groupingBy(Officer::department))
               .entrySet()
               .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> entry.getValue()
                                .stream()
                                .sorted(Comparator.comparingDouble(Officer::salary)
                                        .reversed())
                                .skip(n-1)
                                .limit(1)
                                .collect(Collectors.toList())));
       mp.forEach((k,v) -> System.out.println(k + " : " + v));
    }



    void main(){
        List<Officer> officers = List.of(
                new Officer(1, "Amit",   "IT",      75000, 29, "M", "Pune",    LocalDate.of(2019,3,1),  List.of("Java","Spring"), null),
                new Officer(2, "Sneha",  "IT",      82000, 31, "F", "Pune",    LocalDate.of(2018,7,15), List.of("Java","Angular"), 1),
                new Officer(3, "Rahul",  "HR",      55000, 41, "M", "Mumbai",  LocalDate.of(2015,1,10), List.of("Excel","Comm"), null),
                new Officer(4, "Priya",  "IT",      91000, 35, "F", "Mumbai",  LocalDate.of(2016,5,20), List.of("Java","AWS"), 1),
                new Officer(5, "Karan",  "Finance", 62000, 27, "M", "Pune",    LocalDate.of(2021,9,5),  List.of("Excel","SQL"), null),
                new Officer(6, "Divya",  "HR",      58000, 25, "F", "Mumbai",  LocalDate.of(2022,2,18), List.of("Comm"), 3),
                new Officer(7, "Vikram", "Finance", 71000, 38, "M", "Delhi",   LocalDate.of(2014,11,1), List.of("SQL","Excel"), null),
                new Officer(8, "Neha",   "IT",      82000, 26, "F", "Delhi",   LocalDate.of(2020,6,12), List.of("Angular","CSS"), 1),
                new Officer(9, "Suresh", "Finance", 62000, 45, "M", "Pune",    LocalDate.of(2011,4,3),  List.of("SQL"), 7),
                new Officer(10,"Anita",  "HR",      58000, 33, "F", "Pune",    LocalDate.of(2017,8,9),  List.of("Comm","Excel"), 3)
        );

        //Q1. Names of all employees in IT department.
        // getNameOfEmployeesInITDepartment(officers);

        //Q2. Employees with salary > 70000, sorted by salary descending.
        //getEmployeesGreaterThanSomethingInDecendingOrder(officers);

        //Q3. Count of employees per department.
        //countEmployeesByDepartment(officers);

        //Q4. Total salary expense across the company.
       // getTotalSalaryExpenseForCompany(officers);

        //Q5.Average salary of the company (careful with rounding).
        //getAverageSalaryOfCompany(officers);

        //Q6. Group employee names by department.
        //groupEmployeeNamesByDepartment(officers);

        //Q7. Group by department, then by gender → count. (2-level groupingBy — a classic trap because people forget the downstream collector needs to be groupingBy too, not toList.)
        //groupByDepartmentThenGenderAndCount(officers);

        //Q8. Average salary per department.
        //getAverageSalaryPerDepartment(officers);

        //Q9. Highest-paid employee in each department.
        //getHighestPaidEmployeeInEachDepartment(officers);
        //topEarnerPerDepartment(officers);

        //Q10. Department-wise list of employee names who joined after 2018.
        //getEmployeeNamesWhoJoinedAfter2018InEachDepartment(officers);

        //Q11. Split employees into salary >= 65000 vs < 65000.
       // getEmployeeBySalaryWithPartitioning(officers);

       // Q12. Partition by "above 30" and, within each partition, count by department.
        //getPartitionByAgeAndCountByDepartment(officers);

        //Q13. Sort by department ascending, then salary descending.
        //getEmployeesByDepartmentInAscendingAndSalaryInDecendingOrder(officers);

        //Q14. Sort by age, nulls-safe on managerId (managers with no manager, i.e. null, should sort last).
        //getSortByAgeAndNullShouldBeLast(officers); //This is a common trap since Comparator.comparing throws NPE on nulls.

        //Q15. Total salary using reduce instead of mapToDouble.sum().
        //getTotalSalary(officers);

        //Q16. Find the highest-paid employee using reduce (not max).
        //getHighestPaidEmployeeUsingReduce(officers);

        //Q27. Nth highest-paid employee per department (e.g. 2nd highest in each dept) — combines grouping + sorting + skip/limit inside a downstream collector.
        getNthHighestPaidEmployeePerDepartment(officers);
    }




}



record Officer(int id,
         String name,
         String department,
         double salary,
         int age,
         String gender,     // "M" / "F"
         String city,
         LocalDate joiningDate,
         List<String>skills,
         Integer managerId){

}