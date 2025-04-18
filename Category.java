import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Category {
    
    public Category() {
        // Set up the frame
        CategoryController controller = new CategoryController();
        JFrame frame = new JFrame("Category Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null); // Use null layout

        // Create two panels
        JPanel addPanel = new JPanel();
        addPanel.setBackground(Color.LIGHT_GRAY);
        addPanel.setBounds(5, 50, 374, 250); // Set position and size
        addPanel.setLayout(null);

          // Create buttons for back to main menu
        
        JLabel label1 = new JLabel("");
        label1.setBounds(10, 10, 100, 30); // Absolute positioning
        addPanel.add(label1);

        JTextField textField = new JTextField();
        textField.setBounds(50, 50, 300, 40); // Set position and size

        // Customize the JTextField for a minimalist look
        textField.setFont(new Font("Arial", Font.PLAIN, 16)); // Set clean font
        textField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Remove default border
        textField.setBackground(new Color(245, 245, 245)); // Light gray background
        textField.setForeground(Color.DARK_GRAY); // Text color
        textField.setCaretColor(Color.BLACK); // Cursor color
        addPanel.add(textField);
 
        JButton AddButton = new JButton("Submit");
        AddButton.setBounds(130, 200, 100, 30); // Set position and size
        AddButton.setFont(new Font("Arial", Font.PLAIN, 10)); // Clean, simple font
        AddButton.setBorderPainted(false); // Remove border for simplicity
        AddButton.setFocusPainted(false); // Remove focus effect
        AddButton.setBackground(new Color(245, 245, 245)); // Light gray background
        AddButton.setForeground(Color.BLACK); // Dark gray text color
        AddButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        // AddButton.setEnabled(false);
        addPanel.add(AddButton);
        JPanel editdeletePanel = new JPanel();
        editdeletePanel.setBackground(Color.CYAN);
        editdeletePanel.setBounds(50, 50, 300, 250); // Set position and size
        editdeletePanel.setLayout(null);

        JLabel label2 = new JLabel("This is Panel 2");
        label2.setBounds(100, 50, 100, 30); // Absolute positioning
        editdeletePanel.add(label2);

        // Create buttons for switching panels
        JButton showPanel1 = new JButton("Add Category");
        showPanel1.setBounds(50, 320, 120, 30); // Set position and size
        showPanel1.setFont(new Font("Arial", Font.PLAIN, 10)); // Clean, simple font
        showPanel1.setBorderPainted(false); // Remove border for simplicity
        showPanel1.setFocusPainted(false); // Remove focus effect
        showPanel1.setBackground(new Color(245, 245, 245)); // Light gray background
        showPanel1.setForeground(Color.BLACK); // Dark gray text color
        showPanel1.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor to hand
        JButton backMenu = new JButton("Back to Menu");
        backMenu.setBounds(10, 10, 120, 30);
        backMenu.setFont(new Font("Arial", Font.PLAIN, 10)); // Clean, simple font
        backMenu.setBorderPainted(false); // Remove border for simplicity
        backMenu.setFocusPainted(false); // Remove focus effect
        backMenu.setBackground(new Color(245, 245, 245)); // Light gray background
        backMenu.setForeground(Color.BLACK); // Dark gray text color
        backMenu.setCursor(new Cursor(Cursor.HAND_CURSOR)); //
        JButton showPanel2 = new JButton("Edit/Delete Category");
        showPanel2.setBounds(180, 320, 170, 30); // Set position and size
        showPanel2.setFont(new Font("Arial", Font.PLAIN, 10)); // Clean, simple font
        showPanel2.setBorderPainted(false); // Remove border for simplicity
        showPanel2.setFocusPainted(false); // Remove focus effect
        showPanel2.setBackground(new Color(245, 245, 245)); // Light gray background
        showPanel2.setForeground(Color.BLACK); // Dark gray text color
        showPanel2.setCursor(new Cursor(Cursor.HAND_CURSOR)); //
        // Add action listeners to switch panels
        showPanel1.addActionListener(e -> {
            addPanel.setVisible(true);
            editdeletePanel.setVisible(false);
        });

        showPanel2.addActionListener(e -> {
            addPanel.setVisible(false);
            editdeletePanel.setVisible(true);
        });

        // Add components to the frame
        frame.add(addPanel);
        frame.add(editdeletePanel);
        frame.add(backMenu);
        frame.add(showPanel1);
        frame.add(showPanel2);

        // Initially show Panel 1
        addPanel.setVisible(true);
        editdeletePanel.setVisible(false);

        // Make the frame visible
        frame.setVisible(true);


        //functions
        backMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainMenu(); // Navigate to the Category GUI
                frame.dispose(); // Dispose the current Menu window
            }
        });
        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                
                       
                    String name = textField.getText();
                    controller.addCategory(new CategoryModel( name));
                    JOptionPane.showMessageDialog(frame, "Category Added: " + name);
                    textField.setText("");
                    
            }
        });
    }

    
}
