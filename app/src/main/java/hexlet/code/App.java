package hexlet.code;

import hexlet.code.interaction.Greet;
import hexlet.code.games.EvenGame;
import hexlet.code.games.CalcGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.interaction.Exit;
import java.util.Scanner;

/*
App — игровое меню
- выбор игры

Пакет games:
- все игры
- класс игры — формирует массив вопросов/ответов
- передает в Engine

Пакет Engine:
Cодержит кдасс Engine для взаимодействия с пользователем

Пакет interaction:
- Greet приветствие и хранение имени
- Exit прощание

Пакет utilities:
- RandomUtilities метод генерации случайных чисел
*/


public class App {
    private static final int GREET = 1;
    private static final int EVEN = 2;
    private static final int CALC = 3;
    private static final int GCD = 4;
    private static final int PROGRESSION = 5;
    private static final int PRIME = 6;
    private static final int EXIT = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var gameSelection = "\n" + "Please enter the game number and press Enter.";
        var choice = "Your choice: ";

        int[] games = {GREET, EVEN, CALC, GCD, PROGRESSION, PRIME, EXIT};
        String[] menuText = {" - Greet", " - Even", " - Calc",
                             " - GCD", " - Progression", " - Prime",
                             " - Exit"};

        System.out.println(gameSelection);
        for (var i = 0; i < games.length; i++) {
            System.out.println(games[i] + menuText[i]);
        }

        var userChoiceText = scanner.nextLine();
        try {
            var userChoice = Integer.parseInt(userChoiceText);
            switch (userChoice) {
                case GREET:
                    System.out.println(choice + userChoice + "\n");
                    Greet.greeting();
                    break;
                case EVEN:
                    System.out.println(choice + userChoice + "\n");
                    EvenGame.play();
                    break;
                case CALC:
                    System.out.println(choice + userChoice + "\n");
                    CalcGame.play();
                    break;
                case GCD:
                    System.out.println(choice + userChoice + "\n");
                    GcdGame.play();
                    break;
                case PROGRESSION:
                    System.out.println(choice + userChoice + "\n");
                    ProgressionGame.play();
                    break;
                case PRIME:
                    System.out.println(choice + userChoice + "\n");
                    PrimeGame.play();
                    break;
                case EXIT:
                    System.out.println(choice + userChoice + "\n");
                    Exit.parting();
                    break;
                default:
                    System.out.println("The game with this number does not exist.");
            }
        } catch (NumberFormatException e) {
            System.out.println("\n" + "It seems you entered text :("
                    + "\n" + "Everything is broken!"
                    + "\n" + "Restart the game, please"
                    + "\n");
        }
    }
}
