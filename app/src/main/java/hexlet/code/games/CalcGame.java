package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utilities.RandomUtilities;

public final class CalcGame {
    private static final int MIN_RANDOM = 1;
    private static final int MAX_RANDOM_FIRST = 20;
    private static final int MAX_RANDOM_SECOND = 10;

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
        final char[] operators = {'+', '-', '*'};
        var numberOne = RandomUtilities.randomNumber(MIN_RANDOM, MAX_RANDOM_FIRST);
        var numberTwo = RandomUtilities.randomNumber(MIN_RANDOM, MAX_RANDOM_SECOND);

        var indexOperator = RandomUtilities.randomNumber(0, operators.length - 1);
        var operator = operators[indexOperator];

        var currentQuestion = numberOne + " " + operator + " " + numberTwo;
        var currentAnswer = Integer.toString(calculate(numberOne, numberTwo, operator));

        return new String[]{currentQuestion, currentAnswer};
    }

    public static int calculate(int numberOne, int numberTwo, char operator) {
        switch (operator) {
            case '+':
                return numberOne + numberTwo;
            case '-':
                return numberOne - numberTwo;
            case '*':
                return numberOne * numberTwo;
            default:
                throw new IllegalStateException("Unexpected operation: " + operator);
        }
    }
}
