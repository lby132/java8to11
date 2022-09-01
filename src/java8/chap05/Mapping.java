package java8.chap05;

import java8.chap04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java8.chap04.Dish.menu;

public class Mapping {

    public static void main(String[] args) {
        // map
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(toList());
        System.out.println("dishNames = " + dishNames);

        // map
        List<String> words = Arrays.asList("Hello", "World");
        final List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        System.out.println("wordLengths = " + wordLengths);

        // flatMap
        words.stream()
                .flatMap((String line) -> Arrays.stream(line.split("")))
                .distinct()
                .collect(toList())
                .forEach(System.out::println);

        // flatMap
        List<Integer> number1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> number2 = Arrays.asList(6, 7, 8);
        List<int[]> pairs = number1.stream()
                .flatMap((Integer i) -> number2.stream().map((Integer j) -> new int[]{i, j}))
                .collect(toList());
        pairs.forEach(pair -> System.out.printf("(%d %d)", pair[0], pair[1]));
    }
}
