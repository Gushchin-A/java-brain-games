package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utilities.RandomUtilities;

public final class PrimeGame {
    private static final int MIN_RANDOM = 0;
    private static final int MAX_RANDOM = 100;

    private static final int FIRST_DIVISOR = 3;

    private static final int ROW = 3;
    private static final int COLUMNS = 2;

    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private static String currentAnswer;
    private static int currentQuestion;
    private static int step = 0;
    private static int primeWas = 0;

    public static void play() {

        var rounds = new String[ROW][COLUMNS];

        for (var round : rounds) {
            generateQuestionAnswer();
            round[0] = String.valueOf(currentQuestion);
            round[1] = currentAnswer;
        }

        Engine.start(DESCRIPTION, rounds);
    }
    // чтобы точно выпало хотя бы один раз простое число
    // реализованы переменные step — текущее количество вопросов
    // и переменнная primeWas — простое число уже было или нет
    // если простого числа еще не было, то в третьем круге мы точно
    // покажем простое число
    public static void generateQuestionAnswer() {
        currentQuestion = RandomUtilities.randomNumber(MIN_RANDOM, MAX_RANDOM);

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
    }

    public static boolean isPrime(int number) {

        if (number == 2) {
            return true;
        }

        if (number < 2 || number % 2 == 0) {
            return false;
        }

        double squareNumber = Math.sqrt(number);
        var limit = (int) squareNumber;

        for (var i = FIRST_DIVISOR; i <= limit; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
