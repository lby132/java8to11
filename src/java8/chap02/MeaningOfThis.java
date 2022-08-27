package java8.chap02;

public class MeaningOfThis {

    public final int value = 4;

    public void doIt() {
        int value = 6;
        final Runnable r = new Runnable() {
            int value = 5;
            @Override
            public void run() {
                int value = 10;
                System.out.println("value = " + this.value);
            }
        };
        r.run();
    }

    public static void main(String[] args) {
        final MeaningOfThis m = new MeaningOfThis();
        m.doIt();
    }
}
