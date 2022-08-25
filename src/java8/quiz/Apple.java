package java8.quiz;

public class Apple {
    String apple1;
    String apple2;
    String apple3;
    String color;
    int weight;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getApple1() {
        return apple1;
    }

    public void setApple1(String apple1) {
        this.apple1 = apple1;
    }

    public String getApple2() {
        return apple2;
    }

    public void setApple2(String apple2) {
        this.apple2 = apple2;
    }

    public String getApple3() {
        return apple3;
    }

    public void setApple3(String apple3) {
        this.apple3 = apple3;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "apple1='" + apple1 + '\'' +
                ", apple2='" + apple2 + '\'' +
                ", apple3='" + apple3 + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
