import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.CategoryController;
public class MainMenu {
    public MainMenu() {

        CategoryController controller = new CategoryController();
        controller.loadCategoriesFromFile(); 
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
        JButton MenuButton = new JButton("Menu Management UI");
        MenuButton.setBounds(100, 75, 200, 30);
        MenuButton.setBorderPainted(false);  // Remove border
        MenuButton.setFocusPainted(false);   // Remove focus border
        MenuButton.setContentAreaFilled(false); // Remove background fill
        MenuButton.setOpaque(true); // Ensure background is visible
        MenuButton.setBackground(new Color(50, 150, 250)); // Set background color
        MenuButton.setForeground(Color.WHITE); // Set text color
        MenuButton.setFont(new Font("Arial", Font.BOLD, 14));
      
        JButton categoryButton = new JButton("Category Management");
        categoryButton.setBounds(100, 120, 200, 30);
        categoryButton.setBorderPainted(false);  // Remove border
        categoryButton.setFocusPainted(false);   // Remove focus border
        categoryButton.setContentAreaFilled(false); // Remove background fill
        categoryButton.setOpaque(true); // Ensure background is visible
        categoryButton.setBackground(new Color(50, 150, 250)); // Set background color
        categoryButton.setForeground(Color.WHITE); // Set text color
        categoryButton.setFont(new Font("Arial", Font.BOLD, 14));

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(100, 165, 200, 30);
        exitButton.setBorderPainted(false);  // Remove border
        exitButton.setFocusPainted(false);   // Remove focus border
        exitButton.setContentAreaFilled(false); // Remove background fill
        exitButton.setOpaque(true); // Ensure background is visible
        exitButton.setBackground(new Color(50, 150, 250)); // Set background color
        exitButton.setForeground(Color.WHITE); // Set text color
        exitButton.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel Label = new JLabel("Created by: Arlyn Visperas");
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
        MenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
               
               
              
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

    public static void main(String[] args) {
        new MainMenu(); // Start the MainMenu
    }
}
