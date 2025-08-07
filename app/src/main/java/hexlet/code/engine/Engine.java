package hexlet.code.engine;

import hexlet.code.interaction.Greet;
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

    public static void start(String description, String[][] rounds) {
        Scanner scanner = new Scanner(System.in);

        Greet.greeting();
        System.out.println(description);

        final var maxCorrectAnswers = 3;
        var countRound = 0;

        while (countRound < maxCorrectAnswers) {
            var currentQuestion = rounds[countRound][0];
            var currentAnswer = rounds[countRound][1];

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
                System.out.println("Let's try again, " + Greet.getUserName() + "!" + "\n");
                break;

            }
        }
        if (countRound == maxCorrectAnswers) {
            System.out.println("\n" + "Congratulations, " + Greet.getUserName() + "!" + "\n");
        }
    }
}
