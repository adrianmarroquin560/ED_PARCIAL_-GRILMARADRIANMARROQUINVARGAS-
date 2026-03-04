import algorithms.BusquedaLineal;
import algorithms.Factorial;
import algorithms.Fibonacci;
import algorithms.OrdenamientoBurbuja;
import benchmark.Medidor;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import utils.GeneradorDatos;

public class Main {
    public static void main(String[] args) {
        new File("resultados").mkdirs();

        try (FileWriter fw = new FileWriter("resultados/tiempos.csv")) {
            fw.write("Algoritmo,Version,n,Tiempo_ms\n");

            int[] nsFactorial = {5, 10, 15, 20, 25, 30};
            for (int n : nsFactorial) {
                double tIter = Medidor.medirPromedioMillis(() -> Factorial.factorialIterativo(n));
                System.out.println("Medición: Factorial Iterativo n=" + n + " tiempo=" + tIter);
                fw.write(String.format("Factorial,Iterativo,%d,%.6f%n", n, tIter));

                double tRec = Medidor.medirPromedioMillis(() -> Factorial.factorialRecursivo(n));
                System.out.println("Medición: Factorial Recursivo n=" + n + " tiempo=" + tRec);
                fw.write(String.format("Factorial,Recursivo,%d,%.6f%n", n, tRec));
            }

            int[] nsFib = {5, 10, 15, 20, 25, 30};
            for (int n : nsFib) {
                double tIter = Medidor.medirPromedioMillis(() -> Fibonacci.fibonacciIterativo(n));
                System.out.println("Medición: Fibonacci Iterativo n=" + n + " tiempo=" + tIter);
                fw.write(String.format("Fibonacci,Iterativo,%d,%.6f%n", n, tIter));

                if (n <= 30) {
                    double tRec = Medidor.medirPromedioMillis(() -> Fibonacci.fibonacciRecursivo(n));
                    System.out.println("Medición: Fibonacci Recursivo n=" + n + " tiempo=" + tRec);
                    fw.write(String.format("Fibonacci,Recursivo,%d,%.6f%n", n, tRec));
                } else {
                    fw.write(String.format("Fibonacci,Recursivo,%d,NA%n", n));
                }
            }

            int[] nsLinealBurbuja = {100, 500, 1000, 5000, 10000};
            for (int n : nsLinealBurbuja) {
                int[] base = GeneradorDatos.generarArregloAleatorio(n, n * 10);
                int target = base[n / 2];

                final int[] copiaBuscarIter = GeneradorDatos.clonar(base);
                double tBuscarIter = Medidor.medirPromedioMillis(() ->
                        BusquedaLineal.buscarIterativo(copiaBuscarIter, target));
                System.out.println("Medición: BusquedaLineal Iterativo n=" + n + " tiempo=" + tBuscarIter);
                fw.write(String.format("BusquedaLineal,Iterativo,%d,%.6f%n", n, tBuscarIter));

                final int[] copiaBuscarRec = GeneradorDatos.clonar(base);
                double tBuscarRec = Medidor.medirPromedioMillis(() ->
                        BusquedaLineal.buscarRecursivo(copiaBuscarRec, target));
                System.out.println("Medición: BusquedaLineal Recursivo n=" + n + " tiempo=" + tBuscarRec);
                fw.write(String.format("BusquedaLineal,Recursivo,%d,%.6f%n", n, tBuscarRec));

                final int[] copiaBurbujaIter = GeneradorDatos.clonar(base);
                double tBurbujaIter = Medidor.medirPromedioMillis(() -> {
                    OrdenamientoBurbuja.burbujaIterativo(copiaBurbujaIter);
                });
                System.out.println("Medición: Burbuja Iterativo n=" + n + " tiempo=" + tBurbujaIter);
                fw.write(String.format("Burbuja,Iterativo,%d,%.6f%n", n, tBurbujaIter));

                final int[] copiaBurbujaRec = GeneradorDatos.clonar(base);
                double tBurbujaRec = Medidor.medirPromedioMillis(() -> {
                    OrdenamientoBurbuja.burbujaRecursivo(copiaBurbujaRec);
                });
                System.out.println("Medición: Burbuja Recursivo n=" + n + " tiempo=" + tBurbujaRec);
                fw.write(String.format("Burbuja,Recursivo,%d,%.6f%n", n, tBurbujaRec));
            }

            System.out.println("Mediciones completadas. Archivo: resultados/tiempos.csv");

        } catch (IOException e) {
            System.err.println("Error escribiendo resultados: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

