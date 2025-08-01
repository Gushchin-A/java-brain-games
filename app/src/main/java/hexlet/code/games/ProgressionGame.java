package hexlet.code.games;

import hexlet.code.games.interfaces.Game;
import hexlet.code.utilities.RandomUtilities;

/*
ProgressionGame — игра с поиском пропущенного числа в последовательности
- класс имплементирует Game

Метод generateQuestionAnswer():
- генерация последовательности
- создание вопроса и ответа
*/

public class ProgressionGame implements Game {
    private String currentQuestion;
    private int currentAnswer;
    private int step = RandomUtilities.randomNumber(2, 4);

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
        var progression = new Integer[10];
        var start = RandomUtilities.randomNumber(1, 16);
        var hiddenIndex = RandomUtilities.randomNumber(0, 9);
        for (var i = 0; i < 10; i++) {
            var currentElement = start + i * step;
            progression[i] = currentElement;
        }
        var coefficientStep = RandomUtilities.randomNumber(1, 3);
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
