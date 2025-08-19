package hexlet.code;

import hexlet.code.games.EvenGame;
import hexlet.code.games.CalcGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeGame;

import java.util.Scanner;

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

        var menuDescription = "\n" + "Please enter the game number and press Enter.";

        System.out.println(menuDescription);
        System.out.println("1 - Greet"
                + "\n" + "2 - Even"
                + "\n" + "3 - Calc"
                + "\n" + "4 - GCD"
                + "\n" + "5 - Progression"
                + "\n" + "6 - Prime"
                + "\n" + "0 - Exit");

        var userChoiceText = scanner.nextLine();
        try {
            var userChoice = Integer.parseInt(userChoiceText);
            var menuChoice = "Your choice: " + userChoice + "\n";
            System.out.println(menuChoice);
            switch (userChoice) {
                case GREET:
                    Cli.greeting();
                    break;
                case EVEN:
                    EvenGame.play();
                    break;
                case CALC:
                    CalcGame.play();
                    break;
                case GCD:
                    GcdGame.play();
                    break;
                case PROGRESSION:
                    ProgressionGame.play();
                    break;
                case PRIME:
                    PrimeGame.play();
                    break;
                case EXIT:
                    System.out.println("Bye." + "\n");
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
