package hexlet.code.games;

// реализация пункта меню — greet

import java.util.Scanner;

public class Greet {
    public static void greeting() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        var userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
    }
}
