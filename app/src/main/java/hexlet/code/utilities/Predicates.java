package hexlet.code.utilities;

// класс для реализации методов с проверками

public class Predicates {

    // метод, где проверим четное или нет
    // вызывается на 'yes' от пользовтеля
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}

/*
старая реализация поиска игры в каталоге. заменена в app на switch
проверка введенного номера от пользователя

    public static boolean findGame(int[] games, int number) {
        for (var g : games) {
            if (g == number) {
                return true;
            }
        }
        return false;
    }

метод, где проверим нечетное или нет
вызывается на 'no' от пользовтеля

    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }

 */

