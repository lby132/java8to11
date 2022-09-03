package java8.chap05;

import java8.chap04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java8.chap04.Dish.menu;

public class Reducing {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
        Integer sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("sum = " + sum);

        int sum2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println("sum2 = " + sum2);

        int max = numbers.stream().reduce(0, (a, b) -> Integer.max(a, b));
        System.out.println("max = " + max);

        final Optional<Integer> min = numbers.stream().reduce(Integer::min);
        min.ifPresent(System.out::println);

        int calories = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println("Number of calories:" + calories);

    }
}
