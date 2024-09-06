package Project2re;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class savings{
    // tells the user what is in there savings
    double savingBal = 0.0;
    JLabel saveNum = null;

    public savings(){
    
        JFrame saving = new JFrame();
        saving.setTitle("Account");
        saving.setSize(400, 400);
        saving.getContentPane().setBackground(new Color(255, 192, 159));
        saving.setLayout(new GridBagLayout());
        saving.setVisible(true);

        JButton goBack = new JButton("<---");
        saveNum = new JLabel("Saving Balance: " + savingBal);
        goBack.setBackground(new Color(218,255,239));
        goBack.setForeground(new Color(49,47,47));
        saveNum.setFont(new Font("Monospaced",Font.BOLD,15));

        GridBagConstraints layout = new GridBagConstraints();

        layout = new GridBagConstraints();
        layout.gridx = 1;
        layout.gridy = 0;
        layout.insets = new Insets(10, 10, 10, 10);
        saving.add(saveNum, layout);

        layout = new GridBagConstraints();
        layout.gridx = 0;
        layout.gridy = 1;
        layout.insets = new Insets(10, 10, 10, 10);
        saving.add(goBack, layout);

        goBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            saving.dispose();
            }
        });

    }
    
    public void updateSavings(double savingBal) {
        saveNum.setText("Saving Balance: " + savingBal);
    }

    public double getSavingBalance() {
        return savingBal;
    }

    
}
