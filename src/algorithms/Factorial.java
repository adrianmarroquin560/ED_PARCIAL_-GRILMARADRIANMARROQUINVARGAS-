package algorithms;

public class Factorial {
    public static long factorialIterativo(int n) {
        if (n < 0) throw new IllegalArgumentException("n debe ser >= 0");
        long res = 1;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }

    public static long factorialRecursivo(int n) {
        if (n < 0) throw new IllegalArgumentException("n debe ser >= 0");
        if (n == 0) return 1;
        return n * factorialRecursivo(n - 1);
    }
}
