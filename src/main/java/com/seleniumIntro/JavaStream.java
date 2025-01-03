package com.seleniumIntro;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStream {
    public static void main(String[] args) {
//        List<String> names = List.of("Jack", "Emily", "Alice", "Den", "Jane", "Andy", "Jack", "Emily", "John", "Amanda", "Julia");
//        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5, 6, 7, 78, 5, 6, 7, 8, 9, 10);
//        List<Integer> numbers2 = List.of(10, 12, 23, 44, 55, 256, 63, 74, 78, 5, 6, 7, 8, 9, 10);

//        JavaStream instanceOfJavaStream = new JavaStream();
//        instanceOfJavaStream.printEvenNumbersReverseSorted(numbers);


//        // 2. Find names starting with "J"
//        names.stream()
//                .map(String::toUpperCase)
//                .filter(s -> s.startsWith("J"))
//                .sorted(Comparator.reverseOrder())
//                .distinct()
//                .forEach(System.out::println);

        /*
        "::" syntax in Java is called a method reference.
        It is a shorthand for a lambda expression that calls a specific method.
        In the case of System.out::println,
        it refers to the .println method of the System.out object.

        // Printing with standard way:
        .toList();
        System.out.println("Names that starts with J : " + jNames);
        */

//        // 3. Sum of Squares
//        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
//        int sumOfNumbers = numbers.stream()
//                .map(n -> n * n)
//                .reduce(0, Integer::sum);
//        System.out.println(sumOfNumbers);

        // 4. Group People by Age
        class Person {
            String name;
            int age;

            Person(String name, int age) {
                this.name = name;
                this.age = age;
            }
        }

        List<Person> people = List.of(
                new Person("Alice", 30),
                new Person("Bob", 40),
                new Person("Charlie", 30),
                new Person("David", 40),
                new Person("Eve", 50)
        );


        Map<Integer, List<String>> groupedByAge = people.stream()
                .collect(Collectors.groupingBy(
                        person -> person.age,                      // Group by age
                        Collectors.mapping(person -> person.name, // Collect names for each age
                                Collectors.toList())
                ));

        System.out.println(groupedByAge);

    }

    public void printEvenNumbersReverseSorted(List<Integer> listOfNumbers) {
        List<Integer> evenNumbers = listOfNumbers.stream()
                .filter(n -> n % 2 != 0)
                .limit(9)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println("Even numbers: " + evenNumbers);
    }
}
