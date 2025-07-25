package hexlet.code;

import hexlet.code.engine.Engine;
import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.interaction.Greet;
import java.util.Scanner;

/*
App — игровое меню
- Просим пользователя выбрать игру
- Запускаем приветствие
- После запускаем игру

Пакет games содержит:
- Интерфейс Game. Внутри методы всех игр
- Список всех игр
- Одна игра = отдельный class с методами (вопросы, проверка ответов, описание)
- Каждая игра имплементирует интерфейс Game

Пакет engine:
Cодержит class Engine для старта каждой игры.
В метод start передаем объект Game в зависимости от выбора пользователя

Пакет interaction:
Храним взаимодействие с пользователем. На данный момент содержит class Greet с методом приветствия.
Приветствие вызываем в Engine. Имя храним в Greet.

Проверка на четность, генераторы чисел и подобное. Скорее всего перенесу в утилиты.
*/


public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var gameSelection = "Please enter the game number and press Enter.";
        var choice = "Your choice: ";

        int[] games = {1, 2, 3, 0};
        String[] menuText = {" - Greet", " - Even", " - Calc", " - Exit"};

        // выводим меню. можно попробовать сделать циклом
        System.out.print(gameSelection
                + "\n"
                + games[0] + menuText[0]
                + "\n"
                + games[1] + menuText[1]
                + "\n"
                + games[2] + menuText[2]
                + "\n"
                + games[3] + menuText[3]
                + "\n");

        // проверяем что ввел пользователь

        var userChoiceText = scanner.nextLine();
        try {
            var userChoice = Integer.parseInt(userChoiceText);
            switch (userChoice) {
                case 1:
                    System.out.println(choice + userChoice + "\n");
                    Greet.greeting();
                    break;
                case 2:
                    System.out.println(choice + userChoice + "\n");
                    var evenGame = new EvenGame();
                    Engine.start(evenGame);
                    break;
                case 3:
                    System.out.println(choice + userChoice + "\n");
                    var calcGame = new CalcGame();
                    Engine.start(calcGame);
                    break;
                default:
                    System.out.println("The game with this number does not exist.");
            }
        } catch (NumberFormatException e) {
            System.out.println("It seems you entered text :("
                    + "\nEverything is broken!"
                    + "\nRestart the game, please");
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
