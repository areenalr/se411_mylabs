package edu.psu.se411;

import java.util.List;

public class App {

    public static void main(String[] args) {

        // Exercise 1
        String[] cities = {"Riyadh", "Jeddah", "Dammam", "Jizan"};
        PrintableList<String> stringList = new PrintableList<>(cities);

        System.out.println("String List:");
        stringList.printList();

        Integer[] numbers = {1, 2, 3, 4, 5};
        PrintableList<Integer> integerList = new PrintableList<>(numbers);

        System.out.println("Integer List:");
        integerList.printList();


        // Exercise 2
        NumberBox<Integer> intBox = new NumberBox<>();
        intBox.setItem(10);

        System.out.println("Integer item: " + intBox.getItem());
        System.out.println("Integer sum: " + intBox.sum(5));

        NumberBox<Double> doubleBox = new NumberBox<>();
        doubleBox.setItem(20.5);

        System.out.println("Double item: " + doubleBox.getItem());
        System.out.println("Double sum: " + doubleBox.sum(4.5));


        // Exercise 3
        List<Integer> intList = List.of(1, 2, 3, 4);
        List<Double> doubleList = List.of(1.1, 2.2, 3.3);

        System.out.println("Wildcard Integer List:");
        printList(intList);

        System.out.println("Wildcard Double List:");
        printList(doubleList);

        System.out.println("Sum of Integer List: " + sumNumbers(intList));
        System.out.println("Sum of Double List: " + sumNumbers(doubleList));
    }

    public static void printList(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }

    public static double sumNumbers(List<? extends Number> list) {
        double sum = 0;

        for (Number number : list) {
            sum += number.doubleValue();
        }

        return sum;
    }
}