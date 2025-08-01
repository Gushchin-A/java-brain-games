package hexlet.code.games;

import hexlet.code.games.interfaces.Game;
import hexlet.code.utilities.RandomUtilities;

/*
CalcGame — игра калькулятор.
- класс имплементирует Game
- константы — детали работы генерации вопроса и ответа

Метод generateQuestionAnswer():
- генерация выражений
- создание вопроса и ответа
*/

public final class CalcGame implements Game {
    private static final int MIN_RANDOM = 1;
    private static final int MAX_RANDOM_FIRST = 20;
    private static final int MAX_RANDOM_SECOND = 10;
    private static final int MIN_OPERATION = 1;
    private static final int MAX_OPERATION = 3;
    private static final int ADDITION = 1;
    private static final int SUBTRACTION = 2;
    private static final int MULTIPLICATION = 3;

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
    // аргументы в рандом генераторе задаются в полях класса вручную
    // чтобы уменьшить/увеличить сложность
    public void generateQuestionAnswer() {
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
