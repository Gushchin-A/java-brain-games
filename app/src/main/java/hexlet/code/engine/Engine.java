package hexlet.code.engine;

import hexlet.code.games.interfaces.Game;
import hexlet.code.interaction.Greet;
import java.util.Scanner;

/*
Engine — запуск и управление играми
- метод start передаем конкретную игру класса Game
- каждая игра имлементирует интерфейс Game
- константа — максимум правильных ответов

Далее вызываем общее приветствие.
Игра проходит в цикле for. В нем же мы делаем все необходимые проверки:
- для показа вопроса вызываем методы запущенной игры
- для проверки также вызываем метод запущенной игры
- ответ пользователя берем в этом классе в методе start
- ответ пользователя в виде аргумента передает в метод запущенной игры
*/

public class Engine {
    private static final int MAX_CORRECT_ANSWERS = 3;

    public static void start(Game game) {
        Scanner scanner = new Scanner(System.in);

        var questionMenu = "Question: ";
        var answerMenu = "Your answer: ";

        Greet.greeting();
        System.out.println("\n" + game.gameDescription() + "\n");

        for (var i = 0; i <= MAX_CORRECT_ANSWERS; i++) {

            if (i == MAX_CORRECT_ANSWERS) {
                System.out.println("Congratulations, " + Greet.getUserName() + "!" + "\n");
                break;
            }

            var question = game.getQuestion();
            System.out.println(questionMenu + question);
            System.out.print(answerMenu);
            var userAnswer = scanner.nextLine();

            if (game.checkAnswer(userAnswer)) {
                System.out.println("\n" + "Correct!" + "\n");
            } else {
                System.out.println("\n" + "'" + userAnswer + "'"
                        + " is wrong answer ;(. Correct answer was "
                        + "'" + game.getCorrectAnswer() + "'");
                System.out.println("Let's try again, " + Greet.getUserName() + "!" + "\n");
                break;
            }
        }
    }
}
