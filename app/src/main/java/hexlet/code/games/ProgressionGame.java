package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.utilities.RandomUtilities;

/*
ProgressionGame — игра с поиском пропущенного числа в последовательности
- константы — детали работы генерации вопроса и ответа

Метод generateQuestionAnswer():
- создание вопроса и ответа

Метод generateProgression():
- генерация последовательности
*/

public final class ProgressionGame {
    private static final int PROGRESSION_LENGTH = 10;
    private static final int MIN_START = 1;
    private static final int MAX_START = 16;
    private static final int MIN_HIDDEN_INDEX = 0;
    private static final int MAX_HIDDEN_INDEX = 9;

    private static final int MIN_INITIAL_STEP = 2;
    private static final int MAX_INITIAL_STEP = 8;

    private static String currentQuestion;
    private static int currentAnswer;

    public static void play() {

        var description = "What number is missing in the progression?";
        var rounds = new String[3][2];

        for (var i = 0; i < rounds.length; i++) {
            generateQuestionAnswer();
            rounds[i][0] = currentQuestion;
            rounds[i][1] = String.valueOf(currentAnswer);
        }

        Engine.start(description, rounds);
    }

    public static void generateQuestionAnswer() {
        var progression = generateProgression();
        var hiddenIndex = RandomUtilities.randomNumber(MIN_HIDDEN_INDEX, MAX_HIDDEN_INDEX);
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

    public static Integer[] generateProgression() {
        var progression = new Integer[PROGRESSION_LENGTH];
        var start = RandomUtilities.randomNumber(MIN_START, MAX_START);
        var step = RandomUtilities.randomNumber(MIN_INITIAL_STEP, MAX_INITIAL_STEP);

        for (var i = 0; i < PROGRESSION_LENGTH; i++) {
            var currentElement = start + i * step;
            progression[i] = currentElement;
        }

        return progression;
    }
}
