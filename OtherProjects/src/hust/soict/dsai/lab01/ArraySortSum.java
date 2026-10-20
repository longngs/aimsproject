// 6.5 Sort a numeric array, calculate sum and average
package hust.soict.dsai.lab01;

import java.util.Arrays;
import java.util.Scanner;

public class ArraySortSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] arr;
        System.out.print("Enter the number of elements (0 to use the default array): ");
        int n = sc.nextInt();
        if (n <= 0) {
            arr = new double[] { 1789, 2035, 1899, 1456, 2013 };
        } else {
            arr = new double[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Element " + i + ": ");
                arr[i] = sc.nextDouble();
            }
        }
        System.out.println("Original array: " + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("Sorted array:   " + Arrays.toString(arr));

        double sum = 0;
        for (double x : arr) sum += x;
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + (sum / arr.length));
        sc.close();
    }
}
