package com.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        printNumbers(1, 5);

        filterStringWithoutStream();

        filterStringWithStream();

        addTwoListsWithStream();

        findRepeatedPrimesWithStream();
    }

    public static int add(int a, int b) {
        return a + b;
    }

    private static void printNumbers(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println("i = " + i);
        }
    }

    private static void filterStringWithStream() {
        // Sample list of strings
        List<String> names = List.of("Alice", "Bob", "Charlie", "Albert", "Brandon");

        // Keyword to filter by
        String keyword = "Al";

        // Use Stream to filter the list
        List<String> filtered = names.stream()
                .filter(name -> name.contains(keyword))
                .toList();

        // Print the result

        System.out.println("Filtered List: " + filtered);
    }

    private static void filterStringWithoutStream() {
        List<String> names = List.of("Alice", "Bob", "Charlie", "Albert", "Brandon");
        String keyword = "Al";
        List<String> filtered = new java.util.ArrayList<>();
        for (String name : names) {
            if (name.contains(keyword)) {
                filtered.add(name);
            }
        }
        System.out.println("Filtered List: " + filtered);
    }

    // create a method to add 2 different list of strings using stream
    private static void addTwoListsWithStream() {
        List<String> list1 = List.of("Alice", "Bob");
        List<String> list2 = List.of("Charlie", "David");

        List<String> combined = Stream.concat(list1.stream(), list2.stream())
                .toList();

        System.out.println("Combined List: " + combined);
    }

    private static void findRepeatedPrimesWithStream() {
        List<Integer> numbers = List.of(2, 3, 5, 7, 3, 11, 2, 13, 5, 5, 4, 6, 8);
        List<Integer> repeatedPrimes = numbers.stream()
                .filter(App::isPrime)
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println("Repeated prime numbers: " + repeatedPrimes);
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
