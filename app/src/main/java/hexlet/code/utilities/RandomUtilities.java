package hexlet.code.utilities;

/*
RandomUtilities — содержит метод генерации случайного числа
- метод принимает аргументы
- каждая игра вызывает со своими аргументами (чтобы например в калькуляторе
не спрашивать у пользователи операции с числами больше 30)
*/

public class RandomUtilities {

    public static int randomNumber(int lowerRange, int upperRange) {
        var result = Math.random() * (upperRange - lowerRange + 1) + lowerRange;
        return (int) result;
    }
}
