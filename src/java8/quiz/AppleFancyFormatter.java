package java8.quiz;


public class AppleFancyFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
        return "A " + characteristic + " " + apple.getColor() + " apple";
    }
}

class AppleSimpleFormatter implements AppleFormatter {

    @Override
    public String accept(Apple apple) {
        return "An apple of " + apple.getWeight() + "g";
    }

}


