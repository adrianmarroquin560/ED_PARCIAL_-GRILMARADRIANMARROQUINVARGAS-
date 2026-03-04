package utils;

import java.util.Random;

public class GeneradorDatos {
    private static final Random rnd = new Random();

    public static int[] generarArregloAleatorio(int n, int maxValor) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = rnd.nextInt(maxValor);
        return arr;
    }

    public static int[] generarArregloOrdenado(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i;
        return arr;
    }

    public static int[] clonar(int[] arr) {
        int[] c = new int[arr.length];
        System.arraycopy(arr, 0, c, 0, arr.length);
        return c;
    }
}
