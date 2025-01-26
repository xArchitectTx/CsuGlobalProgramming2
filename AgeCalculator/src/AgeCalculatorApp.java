import com.github.lgooddatepicker.components.DatePicker;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.Period;

public class AgeCalculatorApp extends JFrame {
    private DatePicker datePicker;
    private JLabel resultLabel;

    public AgeCalculatorApp() {
        setTitle("Age Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Create date picker with US format
        datePicker = new DatePicker();
        datePicker.setDateToToday();
        
        JButton calculateButton = new JButton("Calculate Age");
        resultLabel = new JLabel("Select your birth date");
        
        calculateButton.addActionListener(e -> calculateAge());

        mainPanel.add(new JLabel("Birth Date:"));
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(datePicker);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(calculateButton);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(resultLabel);

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }

    private void calculateAge() {
        LocalDate birthDate = datePicker.getDate();
        LocalDate today = LocalDate.now();
        
        if (birthDate == null) {
            JOptionPane.showMessageDialog(this, "Please select a birth date!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (birthDate.isAfter(today)) {
            JOptionPane.showMessageDialog(this, "Birth date cannot be in the future!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Period period = Period.between(birthDate, today);
        resultLabel.setText(String.format("Age: %d years, %d months, %d days", 
            period.getYears(), period.getMonths(), period.getDays()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AgeCalculatorApp().setVisible(true));
    }
}