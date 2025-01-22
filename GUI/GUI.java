import java.awt.*;
import javax.swing.*;

public class GUI extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Clears the panel

        // Set color for drawing
        g.setColor(Color.BLUE);

        // Draw a rectangle
        g.drawRect(50, 50, 100, 50);

        // Fill a rectangle
        g.setColor(Color.RED);
        g.fillRect(200, 50, 100, 50);

        // Draw an oval
        g.setColor(Color.GREEN);
        g.drawOval(50, 150, 100, 50);

        // Fill an oval
        g.setColor(Color.ORANGE);
        g.fillOval(200, 150, 100, 50);

        // Draw a line
        g.setColor(Color.BLACK);
        g.drawLine(50, 250, 300, 250);

        // Draw text
        g.setColor(Color.MAGENTA);
        g.drawString("Hello, Graphics!", 50, 300);
    }

    public static void main(String[] args) {
        // Create the JFrame
        JFrame frame = new JFrame("Basic Graphics Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the custom JPanel
        GUI panel = new GUI();
        frame.add(panel);

        // Set size and make the frame visible
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
