import com.github.lgooddatepicker.components.DatePicker;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.Period;

public class AgeCalc extends JFrame {
    private static final int PADDING = 20;
    private static final int SPACING = 10;

    private DatePicker datePicker;
    private JLabel resultLabel;
    private JButton calculateButton;

    public AgeCalc() {
        setTitle("Option 2: Age Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        initializeComponents();
        pack();
        setLocationRelativeTo(null);
    }

    private void initializeComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING));

        // Birth Date Label
        JLabel birthDateLabel = new JLabel("Birth Date:");
        birthDateLabel.setHorizontalAlignment(SwingConstants.LEFT);
        birthDateLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // DatePicker
        datePicker = new DatePicker();
        datePicker.setDateToToday();
        datePicker.setToolTipText("What is the date of your birth?");
        datePicker.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Calculate Button
        calculateButton = new JButton("Calculate Age");
        calculateButton.setToolTipText("Click to calculate your age.");
        calculateButton.addActionListener(e -> calculateAge());
        calculateButton.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Result Label
        resultLabel = new JLabel("Select your birth date");
        resultLabel.setHorizontalAlignment(SwingConstants.LEFT);
        resultLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Add components to the main panel
        mainPanel.add(birthDateLabel);
        mainPanel.add(Box.createVerticalStrut(SPACING));
        mainPanel.add(datePicker);
        mainPanel.add(Box.createVerticalStrut(SPACING));
        mainPanel.add(calculateButton);
        mainPanel.add(Box.createVerticalStrut(SPACING));
        mainPanel.add(resultLabel);

        // Add the main panel to the frame
        add(mainPanel);
    }

    private void calculateAge() {
        LocalDate birthDate = datePicker.getDate();
        LocalDate today = LocalDate.now();

        if (birthDate == null) {
            resultLabel.setText("Invalid birth date.");
            return;
        }

        if (birthDate.isAfter(today)) {
            resultLabel.setText("Invalid birth date.");
            return;
        }

        Period period = Period.between(birthDate, today);
        resultLabel.setText(String.format("Age: %d years, %d months, %d days",
            period.getYears(), period.getMonths(), period.getDays()));
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> new AgeCalc().setVisible(true));
    }
}
