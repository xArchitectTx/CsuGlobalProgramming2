import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class UserAccount {
    private double balance;

    public UserAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

public class BankBalanceApp extends JFrame {
    private UserAccount account;
    private JLabel balanceLabel;

    public BankBalanceApp(double initialBalance) {
        account = new UserAccount(initialBalance);
        setTitle("Bank Balance Application");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                showFinalBalanceAndExit();
            }
        });

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground (new Color(21,25,28));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextField amountField = new JTextField(10);
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton showBalanceButton = new JButton("Show Balance");
        JButton exitButton = new JButton("Exit");
        balanceLabel = new JLabel("Balance: ");

        // Deposit
        depositButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                account.deposit(amount);
                amountField.setText("");
            } catch (NumberFormatException ex) {
                showError("Invalid amount format!");
            }
        });

        // Withdraw
        withdrawButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                account.withdraw(amount);
                amountField.setText("");
            } catch (NumberFormatException ex) {
                showError("Invalid amount format!");
            }
        });

        // Show Balance
        showBalanceButton.addActionListener(e -> {
            balanceLabel.setText(String.format("Current Balance: $%.2f", account.getBalance()));
        });

        // Exit
        exitButton.addActionListener(e -> showFinalBalanceAndExit());

        // Create panel components
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Amount:"));
        inputPanel.add(amountField);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(showBalanceButton);
        buttonPanel.add(exitButton);

        // Add components to main panel
        mainPanel.add(inputPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(buttonPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(balanceLabel);

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void showFinalBalanceAndExit() {
        JOptionPane.showMessageDialog(this, 
            String.format("Final Balance: $%.2f", account.getBalance()));
        System.exit(0);
    }

    public static void main(String[] args) {
        String initialBalanceStr = JOptionPane.showInputDialog("Enter initial balance:");
        if (initialBalanceStr == null) System.exit(0);
        
        try {
            double initialBalance = Double.parseDouble(initialBalanceStr);
            SwingUtilities.invokeLater(() -> {
                BankBalanceApp app = new BankBalanceApp(initialBalance);
                app.setVisible(true);
            });
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid initial balance!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}