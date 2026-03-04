package algorithms;

public class BusquedaLineal {
    public static int buscarIterativo(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    public static int buscarRecursivo(int[] arr, int target) {
        return buscarRecursivoHelper(arr, target, 0);
    }

    private static int buscarRecursivoHelper(int[] arr, int target, int idx) {
        if (idx >= arr.length) return -1;
        if (arr[idx] == target) return idx;
        return buscarRecursivoHelper(arr, target, idx + 1);
    }
}
