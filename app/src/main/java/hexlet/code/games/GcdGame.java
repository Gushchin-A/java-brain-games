package hexlet.code.games;

import hexlet.code.games.interfaces.Game;
import hexlet.code.utilities.Predicates;
import hexlet.code.utilities.RandomUtilities;

/*
GcdGame — игра с поиском наибольшого общего делителя двух чисел.
- класс имплементирует Game
- в данный момент в классе находится метод с генерацией рандомного числа
- возможно метод с генерацией рандомных чисел переедет в утилиты

В полях класса храним:
- два текущих рандомных числа для игры
- текущий правильный ответ
*/

public class GcdGame implements Game {
    private int currentNumberOne;
    private int currentNumberTwo;
    private int currentAnswer;

    @Override
    public String gameDescription() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    public String getQuestion() {
        currentNumberOne = RandomUtilities.randomNumber(1, 100);
        currentNumberTwo = RandomUtilities.randomNumber(1, 100);
        return currentNumberOne + " " + currentNumberTwo;
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        try {
            var answer = Integer.parseInt(userAnswer);
            currentAnswer = Predicates.greatestCommonDivisor(currentNumberOne, currentNumberTwo);
            boolean isCorrect = answer == currentAnswer;
            if (isCorrect) {
                return true;
            }
        } catch (NumberFormatException e) {
            System.out.println("\n" + "Looks like you typed the text."
                    + "\n" + "Or spaces between numbers."
                    + "\n" + "Or something else. But definitely not numbers!"
                    + "\n" + "\n" + "Anyway, the answer is accepted...");
        }
        return false;
    }

    @Override
    public String getCorrectAnswer() {
        return currentAnswer + "";
    }
}
