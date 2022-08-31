package java8.chap04;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class StreamQuiz {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 2011년에 일어난 모든 트랜잭션 찾아서 값을 오름차순으로 절렬
        transactions.stream()
                .filter(a -> a.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .map(Transaction::getTrader)
                .collect(toList())
                .forEach(System.out::println);

        System.out.println("-----------------");

        // 거래자가 근무하는 모든 도시를 중복 없이 나열
        transactions.stream()
                .map(a -> a.getTrader().getCity())
                .distinct()
                .collect(toList())
                .forEach(System.out::println);

        System.out.println("-----------------");

        // 케임브리지에서 근무하는 모든 거래자 찾아서 이름 순으로 정렬
        transactions.stream()
                .filter(a -> a.getTrader().getCity() == "Cambridge")
                .map(Transaction::getTrader)
                .sorted(comparing(Trader::getName))
                .distinct()
                .collect(toList())
                .forEach(System.out::println);

        System.out.println("-----------------");

        // 모든 거래자의 이름을 알파벳순으로 정렬
        transactions.stream()
                .map(a -> a.getTrader())
                .sorted(comparing(Trader::getName))
                .distinct()
                .collect(toList())
                .forEach(System.out::println);

        System.out.println("-----------------");

        // 밀라노에 거래자가 있는가?
        final boolean milanOk = transactions.stream()
                .anyMatch(a -> a.getTrader().getCity() == "Milan");
        System.out.println("milanOk = " + milanOk);

        System.out.println("-----------------");

        // 케임브리지에 거주하는 거래자의 모든 트랜잭션 값 출력
        transactions.stream()
                .filter(a -> a.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .collect(toList())
                .forEach(System.out::println);

        System.out.println("-----------------");

        // 전체 트랜잭션 중 최대값은 얼마인가?
        final Optional<Integer> maxValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println("maxValue = " + maxValue);

        System.out.println("-----------------");

        // 전체 트랜잭션 중 최소값은 얼마인가?
        // 방법 1
        final Optional<Transaction> minValue = transactions.stream()
                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
        System.out.println("minValue = " + minValue);

        // 방법 2
        final Optional<Integer> minValue2 = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min);
        System.out.println("minValue = " + minValue2);
    }
}
