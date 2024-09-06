package Project2re;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class account {
    private String username;
    private String accountNumber;
    private double balance = 100.21;
    JLabel balanceNum = null;
    



    public account(String username) {
        this.username = username;
        this.accountNumber = getAccountNumberFromUserFile(username);
        System.out.println("Account created for user '" + username + "' with number: " + accountNumber);
    
       
        // creates the frame for the account of the user
        JFrame loginFrame = new JFrame();
        loginFrame.setTitle("Account");
        loginFrame.setSize(650, 650);
        loginFrame.getContentPane().setBackground(new Color(255, 192, 159));
        loginFrame.setLayout(new GridBagLayout());
        loginFrame.setVisible(true);
    

        JButton checking = new JButton("Checking Account");
        JButton savings = new JButton("Savings Account");
        JButton withdrawal = new JButton("Withdrawl");
        JButton transfer = new JButton("Transfer");
        JButton deposit = new JButton("Deposit");
        JButton logout = new JButton("Logout");
        JLabel user= new JLabel("Hello " + username);
        JLabel accountNum = new JLabel("Account Number: " + accountNumber);
        balanceNum = new JLabel("Balance: " + balance);
        

        user.setFont(new Font("Monospaced",Font.BOLD,30));
        accountNum.setFont(new Font("Monospaced",Font.BOLD, 15));
        balanceNum.setFont(new Font("Monospaced",Font.BOLD,15));
        checking.setBackground(new Color(218,255,239));
        checking.setForeground(new Color(49,47,47));
        transfer.setBackground(new Color(218,255,239));
        transfer.setForeground(new Color(49,47,47));
        deposit.setBackground(new Color(218,255,239));
        deposit.setForeground(new Color(49,47,47));
        withdrawal.setBackground(new Color(218,255,239));
        withdrawal.setForeground(new Color(49,47,47));
        savings.setBackground(new Color(218,255,239));
        savings.setForeground(new Color(49,47,47));
        logout.setBackground(new Color(218,255,239));
        logout.setForeground(new Color(49,47,47));


        GridBagConstraints layout = new GridBagConstraints();

        layout = new GridBagConstraints();
        layout.gridx = 0;
        layout.gridy = 0;
        layout.insets = new Insets(10, 10, 10, 10);
        loginFrame.add(user, layout);

        layout = new GridBagConstraints();
        layout.gridx = 0;
        layout.gridy = 1;
        layout.insets = new Insets(10, 10, 10, 10);
        loginFrame.add(accountNum, layout);

        layout = new GridBagConstraints();
        layout.gridx = 1;
        layout.gridy = 1;
        layout.insets = new Insets(10, 10, 10, 10);
        loginFrame.add(balanceNum, layout);
        
        layout = new GridBagConstraints();
        layout.gridx = 0;
        layout.gridy = 3;
        layout.insets = new Insets(10, 10, 10, 10);
        loginFrame.add(withdrawal, layout);

        layout = new GridBagConstraints();
        layout.gridx = 3;
        layout.gridy = 3;
        layout.insets = new Insets(10, 10, 10, 10);
        loginFrame.add(transfer, layout);

        layout = new GridBagConstraints();
        layout.gridx = 1;
        layout.gridy = 3;
        layout.insets = new Insets(10, 10, 10, 10);
        loginFrame.add(deposit, layout);

        layout = new GridBagConstraints();
        layout.gridx = 1;
        layout.gridy = 2;
        layout.insets = new Insets(10, 10, 10, 10);
        loginFrame.add(checking, layout);

        layout = new GridBagConstraints();
        layout.gridx = 0;
        layout.gridy = 4;
        layout.insets = new Insets(10, 10, 10, 10);
        loginFrame.add(logout, layout);

        layout = new GridBagConstraints();
        layout.gridx = 0;
        layout.gridy = 2;
        layout.insets = new Insets(10, 10, 10, 10);
        loginFrame.add(savings, layout);
        
        checking.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            new checkings(balance);
        }
        });
        
        savings.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){

            new savings();
        }
        });
        
        logout.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        loginFrame.dispose();
        }
    });

    withdrawal.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          withdrawals();
        }
    });

    transfer.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        transfers();
        }
    });

    deposit.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        desposits();
        }
    });

    
}

private void withdrawals (){
        
        String amountString = JOptionPane.showInputDialog("Enter withdrawal amount:");
        try {
            double amount = Double.parseDouble(amountString);
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                updateBalance(balance);
                JOptionPane.showMessageDialog(null, "Withdrawal successful. New balance: " + balance);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid withdrawal amount or insufficient funds.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
        }
    }

private void desposits (){
    String amountString = JOptionPane.showInputDialog("Enter deposit amount:");
        try {
            double amount = Double.parseDouble(amountString);
            if (amount > 0) {
                balance += amount;
                updateBalance(balance);
                JOptionPane.showMessageDialog(null, "Deposit successful. New balance: " + balance);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid deposit amount. Please enter a positive amount.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
        }
}

private void transfers (){
    String amountString = JOptionPane.showInputDialog("Enter transfer amount:");
    try {
        double amount = Double.parseDouble(amountString);
        if (amount > 0 && amount <= balance) {
            balance -= amount;
                updateBalance(balance);
                new savings();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid transfer amount or insufficient funds.");
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
    }
    

}
    //updates the balance
private void updateBalance(double balance) {
    balanceNum.setText("Balance: " + balance);
}

    
    
    // gets the users account number to display 
private String getAccountNumberFromUserFile(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                String fileUsername = parts[0].split(": ")[1];
                String accountNumber = parts[3].split(": ")[1];  

                if (username.equals(fileUsername)) {
                    return accountNumber;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;
    }

}
