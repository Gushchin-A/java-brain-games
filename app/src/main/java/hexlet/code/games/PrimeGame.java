package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.utilities.RandomUtilities;

/*
PrimeGame — игра с вычисление простого числа.
- константы — детали работы генерации вопроса и ответа

Метод generateQuestionAnswer():
- создание вопроса и ответа

Метод isPrime():
- проверка простое число или нет
*/

public final class PrimeGame {
    private static final int MIN_RANDOM = 0;
    private static final int MAX_RANDOM = 100;

    private static final int FIRST_DIVISOR = 3;

    private static final int ROW = 3;
    private static final int COLUMNS = 2;

    private static String currentAnswer;
    private static int currentQuestion;
    private static int step = 0;
    private static int primeWas = 0;

    public static void play() {

        var description = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        var rounds = new String[ROW][COLUMNS];

        for (var i = 0; i < rounds.length; i++) {
            generateQuestionAnswer();
            rounds[i][0] = String.valueOf(currentQuestion);
            rounds[i][1] = currentAnswer;
        }

        Engine.start(description, rounds);
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
