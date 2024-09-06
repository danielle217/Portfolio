package Project2re;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class bankingUI {
    private JFrame bank;
    private JButton create;
    private JButton login;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    GridBagConstraints layout = null;

    public bankingUI() {
        // the first page that shows

        bank = new JFrame();
        create = new JButton("CREATE ACCOUNT");
        login = new JButton("LOGIN");
        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);

        bank.setSize(650, 650);
        bank.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bank.setTitle("Bank");
        bank.getContentPane().setBackground(new Color(255, 192, 159));
        create.setBackground(new Color(218,255,239));
        login.setBackground(new Color(218,255,239));
        create.setForeground(new Color(49,47,47));
        login.setForeground(new Color(49,47,47));
        bank.setLayout(new GridBagLayout());

        usernameField.setEditable(true);
        usernameField.setText("");

        passwordField.setEditable(true);
        passwordField.setText("");

        GridBagConstraints layout = new GridBagConstraints();
        layout.gridx = 0;
        layout.gridy = 1;
        layout.insets = new Insets(10, 10, 10, 10);
        bank.add(usernameLabel, layout);

        layout = new GridBagConstraints();
        layout.gridx = 0;
        layout.gridy = 2;
        layout.insets = new Insets(10, 10, 10, 10);
        bank.add(passwordLabel, layout);

        layout = new GridBagConstraints();
        layout.gridx = 1;
        layout.gridy = 1;
        layout.insets = new Insets(10, 10, 10, 10);
        bank.add(usernameField, layout);

        layout = new GridBagConstraints();
        layout.gridx = 1;
        layout.gridy = 2;
        layout.insets = new Insets(10, 10, 10, 10);
        bank.add(passwordField, layout);

        layout = new GridBagConstraints();
        layout.gridx = 0;
        layout.gridy = 3;
        layout.insets = new Insets(10, 10, 10, 10);
        bank.add(create, layout);

        layout = new GridBagConstraints();
        layout.gridx = 1;
        layout.gridy = 3;
        layout.insets = new Insets(10, 10, 10, 10);
        bank.add(login, layout);

        bank.setVisible(true);

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCreateAccountWindow();
            }
        });

        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            openLoginWindow();
            }
        });
    }

    private void openLoginWindow() {
        String enteredUsername = usernameField.getText();
        String enteredPassword = passwordField.getText();

        if (checkLogin("Account", enteredUsername, enteredPassword)) {
            
            new account(enteredUsername);

        } else {
            System.out.println("Login failed");
            JLabel failureLabel = new JLabel("Please check your username and password.");
            failureLabel.setFont(new Font("Monospaced",Font.ITALIC,15));

            GridBagConstraints layout = new GridBagConstraints();
            layout.gridx = 1;
            layout.gridy = 4;
            layout.insets = new Insets(10, 10, 10, 10);
            bank.add(failureLabel, layout);

        }
    }
        // checks to see if the information is in the system
    private static boolean checkLogin(String fileName, String username, String password) {
    try (BufferedReader reader = new BufferedReader(new FileReader("Users.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");
            String Username = parts[0].split(": ")[1];
            String Password = parts[1].split(": ")[1];

            if (username.equals(Username) && password.equals(Password)) {
                return true;
        }
    } 
}
    
    catch (IOException ex) {
        ex.printStackTrace();
    }

    return false; 
}

    //opens a window where the user can create an account
    private void openCreateAccountWindow() {
        JFrame createNew = new JFrame();
        createNew.setTitle("Create Account");
        createNew.setSize(575, 575);
        createNew.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        createNew.getContentPane().setBackground(new Color(255, 192, 159));
        createNew.setLayout(new GridBagLayout());
        createNew.setVisible(true);

        GridBagConstraints createLayout;

        JButton save = new JButton("Save");
        JLabel createUsername = new JLabel("Create Username");
        JLabel createPassword = new JLabel("Create Password");
        JLabel email = new JLabel("Enter Email");
        JTextField createUsernameField = new JTextField(15);
        JTextField createPasswordField = new JTextField(15);
        JTextField emailField = new JTextField(15);
        save.setBackground(new Color(218,255,239));
        save.setForeground(new Color(49,47,47));

        createLayout = new GridBagConstraints();
        createLayout.gridx = 0;
        createLayout.gridy = 0;
        createLayout.insets = new Insets(10, 10, 10, 10);
        createNew.add(createUsername, createLayout);

        createLayout = new GridBagConstraints();
        createLayout.gridx = 1;
        createLayout.gridy = 0;
        createLayout.insets = new Insets(10, 10, 10, 10);
        createNew.add(createUsernameField, createLayout);

        createLayout = new GridBagConstraints();
        createLayout.gridx = 0;
        createLayout.gridy = 2;
        createLayout.insets = new Insets(10, 10, 10, 10);
        createNew.add(createPassword, createLayout);

        createLayout = new GridBagConstraints();
        createLayout.gridx = 1;
        createLayout.gridy = 2;
        createLayout.insets = new Insets(10, 10, 10, 10);
        createNew.add(createPasswordField, createLayout);

        createLayout = new GridBagConstraints();
        createLayout.gridx = 0;
        createLayout.gridy = 3;
        createLayout.insets = new Insets(10, 10, 10, 10);
        createNew.add(email, createLayout);

        createLayout = new GridBagConstraints();
        createLayout.gridx = 1;
        createLayout.gridy = 3;
        createLayout.insets = new Insets(10, 10, 10, 10);
        createNew.add(emailField, createLayout);

        createLayout = new GridBagConstraints();
        createLayout.gridx = 1;
        createLayout.gridy = 4;
        createLayout.insets = new Insets(10, 10, 10, 10);
        createNew.add(save, createLayout);

        // saves the information created and then closes the window and goes to the start screen
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newUsername = createUsernameField.getText();
                String newPassword = createPasswordField.getText();
                String newEmail = emailField.getText();
                saveToFile("Users.txt", newUsername, newPassword, newEmail);
                createNew.dispose();
            }
        });
    }
        // the save file 
    private void saveToFile(String fileName, String username, String password, String email) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("Users.txt", true));
            String accountNumber = generateRandomAccountNumber();
            writer.write( "Username: " + username + ", Password: " + password + ", Email: " + email + ", Account Number: " + accountNumber);
            writer.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
        // creates an random account number when the account is created
    private String generateRandomAccountNumber() {
        Random random = new Random();
        int accountNumber = 100000 + random.nextInt(900000); 
        return Integer.toString(accountNumber);
    }
}
