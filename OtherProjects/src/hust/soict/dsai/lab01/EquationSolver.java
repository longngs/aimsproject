// 2.2.6: linear equation, linear system of 2 variables, quadratic equation (real roots only)
package hust.soict.dsai.lab01;

import javax.swing.JOptionPane;

public class EquationSolver {

    private static double ask(String message) {
        while (true) {
            String s = JOptionPane.showInputDialog(null, message);
            if (s == null) {
                System.exit(0);
            }
            try {
                return Double.parseDouble(s.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }
    }

    // ax + b = 0
    public static String solveLinear(double a, double b) {
        if (a == 0) {
            return (b == 0) ? "Infinitely many solutions." : "No solution.";
        }
        return "x = " + (-b / a);
    }

    // a11*x1 + a12*x2 = b1 ; a21*x1 + a22*x2 = b2
    public static String solveSystem(double a11, double a12, double b1, double a21, double a22, double b2) {
        double d = a11 * a22 - a21 * a12;
        double d1 = b1 * a22 - b2 * a12;
        double d2 = a11 * b2 - a21 * b1;
        if (d != 0) {
            return "x1 = " + (d1 / d) + ", x2 = " + (d2 / d);
        }
        if (d1 == 0 && d2 == 0) {
            // check that the system is not contradictory, e.g. 0x1+0x2=5
            boolean row1Zero = a11 == 0 && a12 == 0;
            boolean row2Zero = a21 == 0 && a22 == 0;
            if ((row1Zero && b1 != 0) || (row2Zero && b2 != 0)) {
                return "No solution.";
            }
            return "Infinitely many solutions.";
        }
        return "No solution.";
    }

    // ax^2 + bx + c = 0
    public static String solveQuadratic(double a, double b, double c) {
        if (a == 0) {
            return "a = 0, the equation becomes linear: " + solveLinear(b, c);
        }
        double delta = b * b - 4 * a * c;
        if (delta > 0) {
            double sq = Math.sqrt(delta);
            return "x1 = " + ((-b + sq) / (2 * a)) + ", x2 = " + ((-b - sq) / (2 * a));
        } else if (delta == 0) {
            return "Double root: x = " + (-b / (2 * a));
        }
        return "No real root.";
    }

    public static void main(String[] args) {
        String[] options = { "Linear equation", "Linear system (2 variables)", "Quadratic equation" };
        int choice = JOptionPane.showOptionDialog(null, "Choose the type of equation:", "Equation Solver",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        String result;
        switch (choice) {
            case 0:
                result = solveLinear(ask("ax + b = 0. Enter a:"), ask("Enter b:"));
                break;
            case 1:
                result = solveSystem(ask("a11:"), ask("a12:"), ask("b1:"), ask("a21:"), ask("a22:"), ask("b2:"));
                break;
            case 2:
                result = solveQuadratic(ask("ax^2 + bx + c = 0. Enter a:"), ask("Enter b:"), ask("Enter c:"));
                break;
            default:
                System.exit(0);
                return;
        }
        JOptionPane.showMessageDialog(null, result, "Result", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
