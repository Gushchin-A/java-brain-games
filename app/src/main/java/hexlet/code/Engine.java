package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static void start(String description, String[][] rounds) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        var userName = scanner.nextLine();
        System.out.println("\n" + "Hello, " + userName + "!" + "\n");

        System.out.println(description);

        var countRound = 0;
        for (var round : rounds) {
            var currentQuestion = round[0];
            var currentAnswer = round[1];

            System.out.println("\n" + "Question: " + currentQuestion);
            System.out.print("Your answer: ");
            var userAnswer = scanner.nextLine();

            if (userAnswer.equals(currentAnswer)) {
                System.out.println("\n" + "Correct!");
                countRound++;
            } else {
                System.out.println("\n" + "'" + userAnswer + "'"
                        + " is wrong answer ;(. Correct answer was "
                        + "'" + currentAnswer + "'");
                System.out.println("Let's try again, " + userName + "!" + "\n");
                break;

            }
        }
        if (countRound == rounds.length) {
            System.out.println("\n" + "Congratulations, " + userName + "!" + "\n");
        }
    }
}
