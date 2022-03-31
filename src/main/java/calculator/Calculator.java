package calculator;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Calculator {

    @Contract(pure = true)
    public static @NotNull String add(int a, int b) {
        int result = a + b;
        return "" + a + " + " + b + " = " + result;
    }

    @Contract(pure = true)
    public static @NotNull String subtract(int a, int b) {
        int result = a - b;
        return "" + a + " - " + b + " = " + result;
    }

    @Contract(pure = true)
    public static @NotNull String multiply(int a, int b) {
        int result = a * b;
        return "" + a + " * " + b + " = " + result;
    }

    @Contract(pure = true)
    public static @NotNull String divide(int a, int b) {
        if (b == 0) {
            return "Cannot divide with 0.";
        } else {
            if (a % b == 0) {
                int result = a / b;
                return "" + a + " / " + b + " = " + result;
            } else {
                double result = (double) a / b;
                return "" + a + " / " + b + " = " + result;
            }
        }
    }
}
