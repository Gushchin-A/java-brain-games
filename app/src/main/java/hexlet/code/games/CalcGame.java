package hexlet.code.games;

import hexlet.code.games.interfaces.Game;
import hexlet.code.utilities.RandomUtilities;

/*
CalcGame — игра калькулятор.
- класс имплементирует Game

Метод generateQuestionAnswer():
- генерация выражений
- создание вопроса и ответа
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

    // дополнительно добавлено исключение, если пользователь
    // ввел текст или числа с пробелами
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

    // генерация двух рандомных чисел и выражений
    // аргументы в рандом генераторе можно поменять,
    // чтобы уменьшить/увеличить сложность
    public void generateQuestionAnswer() {
        var numberOne = RandomUtilities.randomNumber(1, 20);
        var numberTwo = RandomUtilities.randomNumber(1, 10);

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
