package java8.quiz;

import java.util.ArrayList;
import java.util.List;

public class GreenAppleFilter {

    public static void main(String[] args) {
        final Apple aa = new Apple();
        List<Apple> apps = new ArrayList<>();
        aa.setApple1("app1");
        aa.setWeight(80);
        aa.setColor("GREEN");
        apps.add(aa);

        prettyPrintApple(apps, new AppleSimpleFormatter());
    }


    static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

}
