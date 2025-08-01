package hexlet.code.games;

import hexlet.code.games.interfaces.Game;
import hexlet.code.utilities.Predicates;
import hexlet.code.utilities.RandomUtilities;

/*
EvenGame — игра проверка четности числа.
- класс имплементирует Game
- константы — детали работы генерации вопроса и ответа

Метод generateQuestionAnswer():
- генерация рандомного числа
- создание вопроса и ответа
*/

public final class EvenGame implements Game {
    private static final int MIN_RANDOM = 0;
    private static final int MAX_RANDOM = 42;

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
        return currentAnswer.equals(userAnswer);
    }

    @Override
    public String getCorrectAnswer() {
        return currentAnswer;
    }

    public void generateQuestionAnswer() {
        currentQuestion = RandomUtilities.randomNumber(MIN_RANDOM, MAX_RANDOM);

        if (Predicates.isEven(currentQuestion)) {
            currentAnswer = "yes";
        } else {
            currentAnswer = "no";
        }
    }
}
