package hexlet.code.games;

import hexlet.code.games.interfaces.Game;
import hexlet.code.utilities.RandomUtilities;

/*
CalcGame — игра калькулятор.
- класс имплементирует Game
- в данный момент в классе находится метод с рандомными выражениями
- возможно метод с генерацией рандомных выражений переедет в утилиты

В методе с генерацией рандомных выражений сразу же вычисляется ответ.
Ответ и выражение записываются в поле класса.
*/

public class CalcGame implements Game {
    private String currentQuestion;
    private int currentAnswer;

    @Override
    public String gameDescription() {
        return "What is the result of the expression?";
    }

    @Override
    public String getQuestion() {
        generateQuestionAnswer();
        return currentQuestion;
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        try {
            var answer = Integer.parseInt(userAnswer);
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

    public void generateQuestionAnswer() {
        var numberOne = RandomUtilities.randomNumber(1, 30);
        var numberTwo = RandomUtilities.randomNumber(1, 20);

        var randomExpressionDouble = Math.random() * 3;
        var randomExpressionInt = (int) randomExpressionDouble;

        switch (randomExpressionInt) {
            case 0:
                currentQuestion = numberOne + " + " + numberTwo;
                currentAnswer = numberOne + numberTwo;
                break;
            case 1:
                currentQuestion = numberOne + " - " + numberTwo;
                currentAnswer = numberOne - numberTwo;
                break;
            case 2:
                currentQuestion = numberOne + " * " + numberTwo;
                currentAnswer = numberOne * numberTwo;
                break;
            default:
                break;
        }
    }
}
