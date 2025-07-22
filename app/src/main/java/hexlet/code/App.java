package hexlet.code;

import hexlet.code.games.EvenGame;
import hexlet.code.games.Greet;
import java.util.Scanner;

// Класс хранит реализацию и логику игрового меню
// Мы приветсуем пользователя
// Просим выбрать игру
// Каждый игра — отдельный класс

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var gameSelection = "Please enter the game number and press Enter.";
        var choice = "Your choice: ";

        int[] games = {1, 2, 0};
        String[] menuText = {" - Greet", " - Even", " - Exit"};

        // выводим меню. можно попробовать сделать циклом
        System.out.print(gameSelection
                + "\n"
                + games[0] + menuText[0]
                + "\n"
                + games[1] + menuText[1]
                + "\n"
                + games[2] + menuText[2]
                + "\n");

        // проверяем что ввел пользователь
        if (scanner.hasNextInt()) {
            var userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1:
                    System.out.println(choice + userChoice + "\n");
                    Greet.greeting();
                    break;
                case 2:
                    System.out.println(choice + userChoice + "\n");
                    EvenGame.startEvenGame();
                    break;
                default:
                    System.out.println("The game with this number does not exist.");
            }
        } else {
            System.out.println("It seems you entered some text and everything broke...");
        }
    }
}


/*
самый первый подход с созданием переменных под каждый пункт меню
после первой сборки решил переделать в массивы т.к. даже с двумя
пунктами меню уже получилось объемно
if также решил переделать в одну строку под поиск элемента
можно было сделать через switch, но хотелось сделать еще чище и не потерять удобство

var menuOneText = " - Greet";
var menuOneNumber = 1;
var menuOne = menuOneNumber + menuOneText;

var menuZeroText = " - Exit";
var menuZeroNumber = 0;
var menuZero = menuZeroNumber + menuZeroText;
 */
