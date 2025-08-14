package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utilities.RandomUtilities;

public final class ProgressionGame {
    private static final int PROGRESSION_LENGTH = 10;
    private static final int MIN_START = 1;
    private static final int MAX_START = 16;

    private static final int MIN_STEP = 2;
    private static final int MAX_STEP = 8;

    private static final int ROW = 3;
    private static final int COLUMNS = 2;

    private static final String DESCRIPTION = "What number is missing in the progression?";

    private static String currentQuestion;
    private static int currentAnswer;

    public static void play() {

        var rounds = new String[ROW][COLUMNS];

        for (var round : rounds) {
            generateQuestionAnswer();
            round[0] = currentQuestion;
            round[1] = String.valueOf(currentAnswer);
        }

        Engine.start(DESCRIPTION, rounds);
    }

    public static void generateQuestionAnswer() {
        var start = RandomUtilities.randomNumber(MIN_START, MAX_START);
        var step = RandomUtilities.randomNumber(MIN_STEP, MAX_STEP);
        var hiddenIndex = RandomUtilities.randomNumber(0, PROGRESSION_LENGTH - 1);

        var progression = generateProgression(start, step, PROGRESSION_LENGTH);
        currentAnswer = Integer.parseInt(progression[hiddenIndex]);
        progression[hiddenIndex] = "..";
        currentQuestion = String.join(" ", progression);
    }

    public static String[] generateProgression(int start, int step, int length) {
        var progression = new String[length];
        for (var i = 0; i < length; i++) {
            var currentElement = start + i * step;
            progression[i] = Integer.toString(currentElement);
        }
        return progression;
    }
}
