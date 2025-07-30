package hexlet.code.games;

import hexlet.code.games.interfaces.Game;
import hexlet.code.utilities.RandomUtilities;

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
        var progression = new int[10];
        var start = RandomUtilities.randomNumber(1, 16);
        var hiddenIndex = RandomUtilities.randomNumber(0, 9);
        for (var i = 0; i < 10; i++) {
            var currentElement = start + i * step;
            progression[i] = currentElement;
        }
        var coefficientStep = RandomUtilities.randomNumber(1, 3);
        step += coefficientStep;
        currentAnswer = progression[hiddenIndex];
        progression[hiddenIndex] = 0;

        StringBuilder progressionResult = new StringBuilder();
        for (var element : progression) {
            if (element == 0) {
                progressionResult.append(" ");
                progressionResult.append("..");
                progressionResult.append(" ");
            } else {
                progressionResult.append(" ");
                progressionResult.append(element);
                progressionResult.append(" ");
            }
        }
        currentQuestion = progressionResult.toString();
    }
}

/*
currentElement = start + index * step(2)


1 + 0 * 2
1

1 + 1 * 2
3

1 + 2 * 2
5

1 + 3 * 2
7

1  + 4 * 2
9

1 + 5 * 2
11

start — какой раз запускаем игру. зависит от правильных ответов пользователя. От 1 до 3
step — сколько прибавляет последовательность
Index — круг счетчика

После каждого правильного ответа от пользователя все три счетчика ++

Логика:

- Из Engine в этот метод последовательности игры передаю аргументы в виде start и step.
Тогда что я буду передавать в остальные игры?

- В самом классе при каждом вызове метода с чеком проверкой ответа,
при положительном исходе внутри этого метода проверки мы меняем поля класс start и step на плюс 1

 */
