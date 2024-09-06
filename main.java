package Project2re;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class main extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new bankingUI();
            
        });
    }
}
