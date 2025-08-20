package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utilities.RandomUtilities;

public final class CalcGame {
    private static final int MIN_RANDOM = 1;
    private static final int MAX_RANDOM_FIRST = 20;
    private static final int MAX_RANDOM_SECOND = 10;

    private static final int MIN_OPERATION = 1;
    private static final int MAX_OPERATION = 3;
    private static final int ADDITION = 1;
    private static final int SUBTRACTION = 2;
    private static final int MULTIPLICATION = 3;

    private static final int ROWS = 3;
    private static final int COLUMNS = 2;

    private static final String DESCRIPTION = "What is the result of the expression?";

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
        var numberOne = RandomUtilities.randomNumber(MIN_RANDOM, MAX_RANDOM_FIRST);
        var numberTwo = RandomUtilities.randomNumber(MIN_RANDOM, MAX_RANDOM_SECOND);
        var operation = RandomUtilities.randomNumber(MIN_OPERATION, MAX_OPERATION);

        var currentQuestion = "";
        var currentAnswer = calculate(numberOne, numberTwo, operation);

        switch (operation) {
            case ADDITION:
                currentQuestion = numberOne + " + " + numberTwo;
                break;
            case SUBTRACTION:
                currentQuestion = numberOne + " - " + numberTwo;
                break;
            case MULTIPLICATION:
                currentQuestion = numberOne + " * " + numberTwo;
                break;
            default:
                break;
        }

        return new String[]{currentQuestion, currentAnswer};
    }

    public static String calculate(int numberOne, int numberTwo, int operation) {
        var addition = numberOne + numberTwo;
        var subtraction = numberOne - numberTwo;
        var multiplication = numberOne * numberTwo;

        if (operation == ADDITION) {
            return String.valueOf(addition);
        } else if (operation == SUBTRACTION) {
            return String.valueOf(subtraction);
        } else if (operation == MULTIPLICATION) {
            return String.valueOf(multiplication);
        }
        throw new IllegalStateException("Unexpected operation: " + operation);
    }
}
