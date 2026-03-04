package algorithms;

public class OrdenamientoBurbuja {
    public static void burbujaIterativo(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void burbujaRecursivo(int[] arr) {
        burbujaRecursivoHelper(arr, arr.length);
    }

    private static void burbujaRecursivoHelper(int[] arr, int n) {
        if (n <= 1) return;
        boolean swapped = false;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int tmp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tmp;
                swapped = true;
            }
        }
        if (!swapped) return;
        burbujaRecursivoHelper(arr, n - 1);
    }
}
