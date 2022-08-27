package java8.chap03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAround {

    private static final String FILE = ExecuteAround.class.getResource("./data.txt").getFile();

    public static void main(String... args) throws IOException {
        // 더 유연하게 리팩토링할 메서드
        String result = processFileLimited();
        System.out.println("result = " + result);

        System.out.println("---");

        final String oneLine = processFile((BufferedReader b) -> b.readLine());
        System.out.println("oneLine = " + oneLine);

        final String twoLine = processFile((BufferedReader b) -> b.readLine() + b.readLine());
        System.out.println("twoLine = " + twoLine);
    }

    public static String processFileLimited() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            return br.readLine();
        }
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            return p.process(br);
        }
    }

    public interface BufferedReaderProcessor {

        String process(BufferedReader b) throws IOException;
    }
}
