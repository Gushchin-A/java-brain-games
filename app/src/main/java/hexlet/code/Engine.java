package hexlet.code;

import java.util.Scanner;

/*
Engine — запуск игр
- от каждой игры получаем описание и массив вопросы/ответы
- приветствие
- начало игры
- проверка ответа от пользователя
- вывод сообщений
*/

public class Engine {
    private static String userName;

    public static void start(String description, String[][] rounds) {
        Scanner scanner = new Scanner(System.in);

        greeting();
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

    public static void greeting() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = scanner.nextLine();
        System.out.println("\n" + "Hello, " + userName + "!" + "\n");
    }
}
