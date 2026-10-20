// 6.1 ChoosingOption
package hust.soict.dsai.lab01;

import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog(null,
                "Do you want to change to the first class ticket?");

        JOptionPane.showMessageDialog(null, "You've chosen: "
                + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));

        // Customized: only two options with custom labels
        Object[] choices = { "I do", "I don't" };
        int custom = JOptionPane.showOptionDialog(null,
                "Do you want to change to the first class ticket?", "Custom options",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
        JOptionPane.showMessageDialog(null, "You've chosen: "
                + (custom == 0 ? "I do" : custom == 1 ? "I don't" : "nothing (dialog closed)"));
        System.exit(0);
    }
}
