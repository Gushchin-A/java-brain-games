package hexlet.code.games;

import hexlet.code.games.interfaces.Game;
import hexlet.code.utilities.Predicates;
import hexlet.code.utilities.RandomUtilities;

/*
PrimeGame — игра с вычисление простого числа.
- класс имплементирует Game
- константы — детали работы генерации вопроса и ответа

Метод generateQuestionAnswer():
- генерация числа
- создание вопроса и ответа
*/

public final class PrimeGame implements Game {
    private static final int MIN_RANDOM = 0;
    private static final int MAX_RANDOM = 100;

    private String currentAnswer;
    private int currentQuestion;
    private int step = 0;
    private int primeWas = 0;

    @Override
    public String gameDescription() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    @Override
    public String getQuestion() {
        generateQuestionAnswer();
        return currentQuestion + "";
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        return currentAnswer.equals(userAnswer);
    }

    @Override
    public String getCorrectAnswer() {
        return currentAnswer;
    }

    // чтобы точно выпало хотя бы один раз простое число
    // реализованы переменные step — текущее количество вопросов
    // и переменнная primeWas — простое число уже было или нет
    // если простого числа еще не было, то в третьем круге мы точно
    // покажем простое число
    public void generateQuestionAnswer() {
        currentQuestion = RandomUtilities.randomNumber(MIN_RANDOM, MAX_RANDOM);

        while (step == 2 && primeWas == 0) {
            currentQuestion = RandomUtilities.randomNumber(MIN_RANDOM, MAX_RANDOM);
            if (Predicates.isPrime(currentQuestion)) {
                break;
            }
        }

        if (Predicates.isPrime(currentQuestion)) {
            currentAnswer = "yes";
            primeWas++;
        } else {
            currentAnswer = "no";
        }
        step++;
    }
}
