package hexlet.code.games;

import hexlet.code.games.interfaces.Game;

public class CalcGame implements Game {
    private String currentExpression;
    private int currentAnswerExpression;

    @Override
    public String gameDescription() {
        return "What is the result of the expression?";
    }

    @Override
    public String getQuestion() {
        generateRandomExpression();
        return currentExpression;
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        try {
            var answer = Integer.parseInt(userAnswer);
            boolean isCorrect = answer == currentAnswerExpression;
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
        return currentAnswerExpression + "";
    }

    public void generateRandomExpression() {
        var numberOneDouble = Math.random() * (20 - 1 + 1) + 1;
        var numberOne = (int) numberOneDouble;

        var numberTwoDouble = Math.random() * (10 - 1 + 1) + 1;
        var numberTwo = (int) numberTwoDouble;

        var randomExpressionDouble = Math.random() * 3;
        var randomExpressionInt = (int) randomExpressionDouble;

        switch (randomExpressionInt) {
            case 0:
                currentExpression = numberOne + " + " + numberTwo;
                currentAnswerExpression = numberOne + numberTwo;
                break;
            case 1:
                currentExpression = numberOne + " - " + numberTwo;
                currentAnswerExpression = numberOne - numberTwo;
                break;
            case 2:
                currentExpression = numberOne + " * " + numberTwo;
                currentAnswerExpression = numberOne * numberTwo;
                break;
            default:
                break;
        }
    }
}
