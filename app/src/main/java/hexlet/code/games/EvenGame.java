package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.utilities.RandomUtilities;

/*
EvenGame — игра проверка четности числа.
- константы — детали работы генерации вопроса и ответа

Метод isEven():
- определение четности
*/

public final class EvenGame {
    private static final int MIN_RANDOM = 0;
    private static final int MAX_RANDOM = 42;

    private static final int ROW = 3;
    private static final int COLUMNS = 2;

    public static void play() {

        var description = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        var rounds = new String[ROW][COLUMNS];

        for (var i = 0; i < rounds.length; i++) {
            var tempNumber = RandomUtilities.randomNumber(MIN_RANDOM, MAX_RANDOM);
            var currentAnswer = isEven(tempNumber) ? "yes" : "no";
            var currentQuestion = String.valueOf(tempNumber);
            rounds[i][0] = currentQuestion;
            rounds[i][1] = currentAnswer;
        }

        Engine.start(description, rounds);
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
