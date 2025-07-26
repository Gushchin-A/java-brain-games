package hexlet.code.utilities;

/*
Predicates — содержит методы проверки
- проверка четности числа
- поиск НОД (наибольший общий делитель)
*/

public class Predicates {

    // проверка четности
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // поиск НОД
    public static int greatestCommonDivisor(int numberOne, int numberTwo) {
        var a = numberOne;
        var b = numberTwo;

        while (b != 0) {
            var temp = a;
            a = b;
            b = temp % b;
        }
        return a;
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

