package hexlet.code.engine;

import hexlet.code.games.interfaces.Game;
import hexlet.code.interaction.Greet;
import java.util.Scanner;

/*
Engine — запуск и управление играми
- метод start передаем конкретную игру класса Game
- каждая игра имлементирует интерфейс Game

Далее вызываем общее приветствие.
Игра проходит в цикле for. В нем же мы делаем все необходимые проверки:
- для показа вопроса вызываем методы запущенной игры
- для проверки также вызываем метод запущенной игры
- ответ пользователя берем в этом классе в методе start
- ответ пользователя в виде аргумента передает в метод запущенной игры
*/

public class Engine {
    public static void start(Game game) {
        Scanner scanner = new Scanner(System.in);

        var questionMenu = "Question: ";
        var answerMenu = "Your answer: ";

        Greet.greeting();
        System.out.println(game.gameDescription());

        for (var i = 0; i <= 3; i++) {

            if (i == 3) {
                System.out.println("Congratulations, " + Greet.getUserName() + "!");
                break;
            }

            var question = game.getQuestion();
            System.out.println(questionMenu + question);
            System.out.print(answerMenu);
            var userAnswer = scanner.nextLine();

            if (game.checkAnswer(userAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "'"
                        + " is wrong answer ;(. Correct answer was "
                        + "'" + game.getCorrectAnswer() + "'");
                System.out.println("Let's try again, " + Greet.getUserName() + "!");
                break;
            }
        }
    }
}
