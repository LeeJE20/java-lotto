package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class testUtil {
    public static void input(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    public static String output() {
        OutputStream captor= new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
        return captor.toString().trim();
    }
}
