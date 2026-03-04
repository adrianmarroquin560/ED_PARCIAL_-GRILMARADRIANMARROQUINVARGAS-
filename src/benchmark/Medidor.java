package benchmark;

import java.util.function.Supplier;

public class Medidor {

    // Mide una tarea que devuelve un valor (Supplier<T>) y retorna el promedio en ms.
    public static <T> double medirPromedioMillis(Supplier<T> funcion) {
        int runs = 5;
        long sumaNanos = 0;
        for (int i = 0; i < runs; i++) {
            System.gc();
            long inicio = System.nanoTime(); 
            T res = funcion.get();
            long fin = System.nanoTime();
            sumaNanos += (fin - inicio);
            if (res == null) {}
        }
        return (sumaNanos / (double) runs) / 1_000_000.0;
    }

    // Sobrecarga para tareas void (Runnable)
    public static double medirPromedioMillis(Runnable tarea) {
        int runs = 5;
        long sumaNanos = 0;
        for (int i = 0; i < runs; i++) {
            System.gc();
            long inicio = System.nanoTime();
            tarea.run();
            long fin = System.nanoTime();
            sumaNanos += (fin - inicio);
        }
        return (sumaNanos / (double) runs) / 1_000_000.0;
    }
}
