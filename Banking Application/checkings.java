package Project2re;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class checkings {
    
    public checkings(double balance){
        double overdraftNum = 0.0;
        JFrame checking = new JFrame();
        checking.setTitle("Account");
        checking.setSize(400, 400);
        checking.getContentPane().setBackground(new Color(255, 192, 159));
        checking.setLayout(new GridBagLayout());
        checking.setVisible(true);

        JLabel balanceNum = new JLabel("Balance: " + balance);
        JLabel overdrafts = new JLabel("Overdraft: " + overdraftNum);


        JButton goBack = new JButton("<---");
        goBack.setBackground(new Color(218,255,239));
        goBack.setForeground(new Color(49,47,47));
        balanceNum.setFont(new Font("Monospaced",Font.BOLD,15));
        overdrafts.setFont(new Font("Monospaced",Font.BOLD,15));

        GridBagConstraints layout = new GridBagConstraints();

        layout = new GridBagConstraints();
        layout.gridx = 1;
        layout.gridy = 0;
        layout.insets = new Insets(10, 10, 10, 10);
        checking.add(balanceNum, layout);

        layout = new GridBagConstraints();
        layout.gridx = 2;
        layout.gridy = 0;
        layout.insets = new Insets(10, 10, 10, 10);
        checking.add(overdrafts, layout);


        layout = new GridBagConstraints();
        layout.gridx = 0;
        layout.gridy = 1;
        layout.insets = new Insets(10, 10, 10, 10);
        checking.add(goBack, layout);

        goBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            checking.dispose();
            }
        });



    }
}
