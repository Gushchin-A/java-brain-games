package hexlet.code.games;

import hexlet.code.games.interfaces.Game;
import hexlet.code.utilities.Predicates;
import hexlet.code.utilities.RandomUtilities;

/*
PrimeGame — игра с вычисление простого числа.
- класс имплементирует Game

Метод generateQuestionAnswer():
- генерация числа
- создание вопроса и ответа
*/

public class PrimeGame implements Game {
    private String currentAnswer;
    private int currentQuestion;
    private int step;
    private int primeWas;

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

        if (!userAnswer.equals("yes") && !userAnswer.equals("no")) {
            throw new IllegalArgumentException("The answer is incorrect");
        }
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
        currentQuestion = RandomUtilities.randomNumber(0, 100);

        while (step == 2 && primeWas == 0) {
            currentQuestion = RandomUtilities.randomNumber(0, 100);
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
