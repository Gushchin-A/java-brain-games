package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utilities.RandomUtilities;

public final class EvenGame {
    private static final int MIN_RANDOM = 0;
    private static final int MAX_RANDOM = 42;

    private static final int ROWS = 3;
    private static final int COLUMNS = 2;

    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void play() {

        var rounds = new String[ROWS][COLUMNS];

        for (var round : rounds) {
            var tempNumber = RandomUtilities.randomNumber(MIN_RANDOM, MAX_RANDOM);
            var currentAnswer = isEven(tempNumber) ? "yes" : "no";
            var currentQuestion = String.valueOf(tempNumber);
            round[0] = currentQuestion;
            round[1] = currentAnswer;
        }

        Engine.start(DESCRIPTION, rounds);
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
