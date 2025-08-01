package hexlet.code.games;

import hexlet.code.games.interfaces.Game;
import hexlet.code.utilities.RandomUtilities;

/*
ProgressionGame — игра с поиском пропущенного числа в последовательности
- класс имплементирует Game
- константы — детали работы генерации вопроса и ответа

Метод generateQuestionAnswer():
- генерация последовательности
- создание вопроса и ответа
*/

public final class ProgressionGame implements Game {
    private static final int PROGRESSION_LENGTH = 10;
    private static final int MIN_START = 1;
    private static final int MAX_START = 16;
    private static final int MIN_HIDDEN_INDEX = 0;
    private static final int MAX_HIDDEN_INDEX = 9;
    private static final int MIN_STEP = 1;
    private static final int MAX_STEP = 3;

    // первая последовательность
    private static final int MIN_INITIAL_STEP = 2;
    private static final int MAX_INITIAL_STEP = 4;

    private String currentQuestion;
    private int currentAnswer;
    private int step = RandomUtilities.randomNumber(MIN_INITIAL_STEP, MAX_INITIAL_STEP);

    @Override
    public String gameDescription() {
        return "What number is missing in the progression?";
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

    /*
    Cоздаем массив из случайных чисел. Находим случайным образом индекс, который скроем
    Записываем правильный ответ, меняем число на null
    Через StringBuilder собираем строку. null меняем на две точки
    Генерация следующей последовательности также генерируется случайным образом.
     */
    @Override
    public String getCorrectAnswer() {
        return currentAnswer + "";
    }

    public void generateQuestionAnswer() {
        var progression = new Integer[PROGRESSION_LENGTH];
        var start = RandomUtilities.randomNumber(MIN_START, MAX_START);
        var hiddenIndex = RandomUtilities.randomNumber(MIN_HIDDEN_INDEX, MAX_HIDDEN_INDEX);
        for (var i = 0; i < PROGRESSION_LENGTH; i++) {
            var currentElement = start + i * step;
            progression[i] = currentElement;
        }
        var coefficientStep = RandomUtilities.randomNumber(MIN_STEP, MAX_STEP);
        step += coefficientStep;
        currentAnswer = progression[hiddenIndex];
        progression[hiddenIndex] = null;

        StringBuilder progressionResult = new StringBuilder();
        for (var element : progression) {
            if (element == null) {
                progressionResult.append("..");
                progressionResult.append(" ");
            } else {
                progressionResult.append(element);
                progressionResult.append(" ");
            }
        }
        currentQuestion = progressionResult.toString().trim();
    }
}
