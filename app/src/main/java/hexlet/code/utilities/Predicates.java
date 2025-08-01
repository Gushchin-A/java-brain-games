package hexlet.code.utilities;

/*
Predicates — содержит методы проверки
- проверка четности числа
- поиск НОД (наибольший общий делитель)
- простое число или нет
*/

public class Predicates {

    // проверка четности
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // поиск наибольшего обшего делителя
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

    // проверка простого числа
    public static boolean isPrime(int number) {

        if (number < 2 || number % 2 == 0) {
            return false;
        }

        if (number == 2) {
            return true;
        }

        double squareNumber = Math.sqrt(number);
        var limit = (int) squareNumber;

        for (var i = 3; i <= limit; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
