package hexlet.code.utilities;

public class RandomUtilities {

    // генератор случайных чисел
    public static int randomNumber(int lowerRange, int upperRange) {
        var result = Math.random() * (upperRange - lowerRange + 1) + lowerRange;
        return (int) result;
    }
}
