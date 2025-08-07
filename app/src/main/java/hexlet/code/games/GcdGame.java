package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.utilities.RandomUtilities;

/*
GcdGame — игра с поиском наибольшого общего делителя двух чисел.
- константы — детали работы генерации вопроса и ответа

Метод generateQuestionAnswer():
- генерация двух чисел
- создание вопроса и ответа

Метод greatestCommonDivisor():
- определение НОД
*/

public final class GcdGame {
    private static final int MIN_RANDOM = 1;
    private static final int MAX_RANDOM = 100;

    private static String currentQuestion;
    private static int currentAnswer;

    public static void play() {

        var description = "Find the greatest common divisor of given numbers.";
        var rounds = new String[3][2];

        for (var i = 0; i < rounds.length; i++) {
            generateQuestionAnswer();
            rounds[i][0] = currentQuestion;
            rounds[i][1] = String.valueOf(currentAnswer);
        }

        Engine.start(description, rounds);
    }

    // генерация двух рандомных чисел и выражений
    // аргументы в рандом генераторе задаются в полях класса
    // чтобы уменьшить/увеличить сложность
    public static void generateQuestionAnswer() {
        var numberOne = RandomUtilities.randomNumber(MIN_RANDOM, MAX_RANDOM);
        var numberTwo = RandomUtilities.randomNumber(MIN_RANDOM, MAX_RANDOM);
        currentQuestion = numberOne + " " + numberTwo;
        currentAnswer = greatestCommonDivisor(numberOne, numberTwo);
    }

    // поиск наибольшего обшего делителя
    public static int greatestCommonDivisor(int numberOne, int numberTwo) {
        var a = numberOne;
        var b = numberTwo;

        while (b != 0) {
            var temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
}
