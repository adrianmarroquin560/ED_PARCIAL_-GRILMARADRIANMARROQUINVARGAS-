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