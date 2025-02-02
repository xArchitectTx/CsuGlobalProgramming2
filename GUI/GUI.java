import java.awt.BorderLayout;
  
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {  
    public static void main(String[] args) {  
        JFrame frame = new JFrame("Layout Demo");  
        JPanel panel = new JPanel(new BorderLayout()); // Set layout during panel creation  

        panel.add(new JButton("North"), BorderLayout.NORTH);  
        panel.add(new JButton("Center"), BorderLayout.CENTER);  

        frame.add(panel);  
        frame.setSize(300, 200);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setVisible(true);  
    }  
}  