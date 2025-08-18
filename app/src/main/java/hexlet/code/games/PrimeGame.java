package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utilities.RandomUtilities;

public final class PrimeGame {
    private static final int MIN_RANDOM = 0;
    private static final int MAX_RANDOM = 100;

    private static final int ROWS = 3;
    private static final int COLUMNS = 2;

    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private static int step = 0;
    private static int primeWas = 0;

    public static void play() {

        var rounds = new String[ROWS][COLUMNS];

        for (var round : rounds) {
            var questionAnswer = generateQuestionAnswer();
            round[0] = questionAnswer[0];
            round[1] = questionAnswer[1];
        }

        Engine.start(DESCRIPTION, rounds);
    }
    // чтобы точно выпало хотя бы один раз простое число
    // реализованы переменные step — текущее количество вопросов
    // и переменнная primeWas — простое число уже было или нет
    // если простого числа еще не было, то в третьем круге мы точно простое число
    public static String[] generateQuestionAnswer() {
        var currentQuestion = RandomUtilities.randomNumber(MIN_RANDOM, MAX_RANDOM);
        var currentAnswer = "";

        while (step == 2 && primeWas == 0) {
            currentQuestion = RandomUtilities.randomNumber(MIN_RANDOM, MAX_RANDOM);
            if (isPrime(currentQuestion)) {
                break;
            }
        }

        if (isPrime(currentQuestion)) {
            currentAnswer = "yes";
            primeWas++;
        } else {
            currentAnswer = "no";
        }
        step++;

        return new String[]{String.valueOf(currentQuestion), currentAnswer};
    }

    public static boolean isPrime(int number) {
        if (number == 2) {
            return true;
        }

        if (number < 2 || number % 2 == 0) {
            return false;
        }

        final int firstDivisor = 3;
        double squareNumber = Math.sqrt(number);
        var limit = (int) squareNumber;

        for (var i = firstDivisor; i <= limit; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
