import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
public class MainMenu {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Ordering System");
        frame.setSize(400, 300);
         frame.setResizable(false);
         frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel
        JPanel panel = new JPanel();
         panel.setBackground(Color.CYAN); // Set the panel color to cyan
        frame.add(panel);
        panel.setLayout(null);

        // Create buttons
          JButton MenuButton = new JButton("Menu Management");
        MenuButton.setBounds(100, 75, 200, 30);
        MenuButton.setBackground(Color.ORANGE);       
          JButton categoryButton = new JButton("Category Management");
        categoryButton.setBounds(100, 120, 200, 30);
       

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(100, 165, 200, 30);
        
        JLabel Label= new JLabel("Created by: Arlyn Visperas");
        Label.setBounds(105, 220, 200, 30);

        panel.add(categoryButton);
        panel.add(MenuButton);
        panel.add(Label);
        panel.add(exitButton);

        // Add action listener to the Category button
        categoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Category(); // Navigate to the Category GUI
                frame.dispose(); // Dispose the current Menu window
            }
        });

        // Add action listener to the Exit button
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the application
            }
        });

        // Set frame visibility
        frame.setVisible(true);
    }
}
