package hexlet.code.games;

import hexlet.code.utilities.Predicates;

import java.util.Scanner;

// реализация пункта меню — Even. Игра проверка четности

public class EvenGame {

    // в одном методе: приветствие, правила, старт
    public static void startEvenGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        var userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        var questionMenu = "Question: ";
        var answerMenu = "Your answer: ";

        // количество правильных ответов
        var index = 0;
        // включаем цикл
        while (index >= 0) {

            if (index == 3) {
                System.out.println("Congratulations, " + userName + "!");
                break;
            }

            // каждый новый цикл генерируем случайное число
            var questionOne = randomNumber();
            System.out.println(questionMenu + questionOne);
            System.out.print(answerMenu);
            var userAnswer = scanner.next();

            if (!userAnswer.equals("yes") && !userAnswer.equals("no")) {
                System.out.println("The answer is incorrect");
                break;
            }

            // вызываем метод isEven если ответ yes
            if (userAnswer.equals("yes")) {
                if (Predicates.isEven(questionOne)) {
                    System.out.println("Correct!");
                    index++;
                } else {
                    System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'.");
                    System.out.println("Let's try again, " + userName + "!");
                    break;
                }
            }

            // вызываем метод isOdd если ответ no
            if (userAnswer.equals("no")) {
                if (Predicates.isOdd(questionOne)) {
                System.out.println("Correct!");
                index++;
            } else {
                System.out.println("'no' is wrong answer ;(. Correct answer was 'yes'.");
                System.out.println("Let's try again, " + userName + "!");
                break;
                }
            }
        }
    }

    // генератор случайных чисел через Math.random
    public static int randomNumber() {

        var randomNumber = Math.random() * 42;
        return (int) randomNumber;
    }
}

/*
реализация псевдоуникального генератора чисел. от него отказался
        int a = 150;
        int c = 130;
        int m = 190;
        long seed = System.currentTimeMillis();
        int longSeedToInt = (int) seed;

        var number = (a * longSeedToInt + c) % m;
        return number;
 */

