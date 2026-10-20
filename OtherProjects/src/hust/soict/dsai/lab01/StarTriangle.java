// 6.3 Display a triangle with a height of n stars
package hust.soict.dsai.lab01;

import java.util.Scanner;

public class StarTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.print("Enter the height n (n > 0): ");
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.print("Please enter an integer: ");
            }
            n = sc.nextInt();
        } while (n <= 0);

        for (int i = 1; i <= n; i++) {
            StringBuilder line = new StringBuilder();
            for (int s = 0; s < n - i; s++) line.append(' ');
            for (int k = 0; k < 2 * i - 1; k++) line.append('*');
            System.out.println(line);
        }
        sc.close();
    }
}
