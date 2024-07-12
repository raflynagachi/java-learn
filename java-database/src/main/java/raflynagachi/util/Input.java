package raflynagachi.util;

import java.util.Scanner;

public class Input {
    public static Scanner scanner = new Scanner(System.in);

    public static String input(String placeholder) {
        System.out.print(placeholder + ": ");
        return scanner.nextLine();
    }
}
