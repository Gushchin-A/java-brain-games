package hexlet.code.games;

import hexlet.code.games.interfaces.Game;
import hexlet.code.utilities.Predicates;
import hexlet.code.utilities.RandomUtilities;

/*
EvenGame — игра проверка четности числа.
- класс имплементирует Game

Метод generateQuestionAnswer():
- генерация рандомного числа
- создание вопроса и ответа
*/

public class EvenGame implements Game {
    private String currentAnswer;
    private int currentQuestion;

    @Override
    public String gameDescription() {
        return "Answer 'yes' if the number is even, "
                + "otherwise answer 'no'.";
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

    public void generateQuestionAnswer() {
        currentQuestion = RandomUtilities.randomNumber(1, 42);

        if (Predicates.isEven(currentQuestion)) {
            currentAnswer = "yes";
        } else {
            currentAnswer = "no";
        }
    }
}
