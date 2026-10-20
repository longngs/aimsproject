// 6.6 Add two matrices of the same size
package hust.soict.dsai.lab01;

import java.util.Scanner;

public class MatrixAddition {
    public static double[][] add(double[][] a, double[][] b) {
        int rows = a.length, cols = a[0].length;
        double[][] c = new double[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                c[i][j] = a[i][j] + b[i][j];
        return c;
    }

    private static double[][] read(Scanner sc, String name, int rows, int cols) {
        double[][] m = new double[rows][cols];
        System.out.println("Enter matrix " + name + " (" + rows + "x" + cols + "):");
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                System.out.print(name + "[" + i + "][" + j + "] = ");
                m[i][j] = sc.nextDouble();
            }
        return m;
    }

    private static void print(String name, double[][] m) {
        System.out.println(name + ":");
        for (double[] row : m) {
            StringBuilder sb = new StringBuilder();
            for (double x : row) sb.append(String.format("%8.2f", x));
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Number of columns: ");
        int cols = sc.nextInt();
        if (rows <= 0 || cols <= 0) {
            System.out.println("Invalid size.");
            return;
        }
        double[][] a = read(sc, "A", rows, cols);
        double[][] b = read(sc, "B", rows, cols);
        print("A", a);
        print("B", b);
        print("A + B", add(a, b));
        sc.close();
    }
}
