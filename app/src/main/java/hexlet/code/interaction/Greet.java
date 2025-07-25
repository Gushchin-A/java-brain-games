package hexlet.code.interaction;

// реализация пункта меню — greet

import java.util.Scanner;

public class Greet {
    private static String userName;

    public static void greeting() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
    }

    public static String getUserName() {
        return userName;
    }

}
