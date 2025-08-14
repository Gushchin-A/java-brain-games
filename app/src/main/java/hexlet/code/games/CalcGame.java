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

    private static final int ROW = 3;
    private static final int COLUMNS = 2;

    private static final String DESCRIPTION = "What is the result of the expression?";

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

    // генерация двух рандомных чисел и выражений
    // аргументы в рандом генераторе задаются в полях класса
    public static void generateQuestionAnswer() {
        var numberOne = RandomUtilities.randomNumber(MIN_RANDOM, MAX_RANDOM_FIRST);
        var numberTwo = RandomUtilities.randomNumber(MIN_RANDOM, MAX_RANDOM_SECOND);
        var randomExpression = RandomUtilities.randomNumber(MIN_OPERATION, MAX_OPERATION);

        switch (randomExpression) {
            case ADDITION:
                currentQuestion = numberOne + " + " + numberTwo;
                currentAnswer = numberOne + numberTwo;
                break;
            case SUBTRACTION:
                currentQuestion = numberOne + " - " + numberTwo;
                currentAnswer = numberOne - numberTwo;
                break;
            case MULTIPLICATION:
                currentQuestion = numberOne + " * " + numberTwo;
                currentAnswer = numberOne * numberTwo;
                break;
            default:
                break;
        }
    }
}
