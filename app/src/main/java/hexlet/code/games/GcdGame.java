package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utilities.RandomUtilities;

public final class GcdGame {
    private static final int MIN_RANDOM = 1;
    private static final int MAX_RANDOM = 100;

    private static final int ROWS = 3;
    private static final int COLUMNS = 2;

    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";

    public static void play() {

        var rounds = new String[ROWS][COLUMNS];

        for (var round : rounds) {
            var questionAnswer = generateQuestionAnswer();
            round[0] = questionAnswer[0];
            round[1] = questionAnswer[1];
        }

        Engine.start(DESCRIPTION, rounds);
    }

    public static String[] generateQuestionAnswer() {
        var numberOne = RandomUtilities.randomNumber(MIN_RANDOM, MAX_RANDOM);
        var numberTwo = RandomUtilities.randomNumber(MIN_RANDOM, MAX_RANDOM);
        var currentQuestion = numberOne + " " + numberTwo;
        var currentAnswer = String.valueOf(greatestCommonDivisor(numberOne, numberTwo));

        return new String[]{currentQuestion, currentAnswer};
    }

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
