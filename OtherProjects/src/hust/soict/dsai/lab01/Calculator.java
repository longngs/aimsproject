// 2.2.5: sum, difference, product and quotient of 2 double numbers
package hust.soict.dsai.lab01;

import javax.swing.JOptionPane;

public class Calculator {
    public static void main(String[] args) {
        String strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ",
                "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        String strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ",
                "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        try {
            double num1 = Double.parseDouble(strNum1);
            double num2 = Double.parseDouble(strNum2);

            String result = "Sum: " + (num1 + num2)
                    + "\nDifference: " + (num1 - num2)
                    + "\nProduct: " + (num1 * num2)
                    + "\nQuotient: " + (num2 == 0 ? "undefined (division by zero)" : String.valueOf(num1 / num2));
            JOptionPane.showMessageDialog(null, result, "Result", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Invalid number!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        System.exit(0);
    }
}
