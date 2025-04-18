import javax.swing.*;
import java.awt.*;

public class Category {
    private JTextField categoryField;
    private JButton addButton;

    public Category() {
        // Set up the frame
        JFrame frame = new JFrame();
        frame.setTitle("Add Category");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null); // Center the window
        frame.setResizable(false);

        // Create components
        JLabel label = new JLabel("Enter Category:");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(label, BorderLayout.NORTH);

        categoryField = new JTextField();
        frame.add(categoryField, BorderLayout.CENTER);

        addButton = new JButton("Add Category");
        frame.add(addButton, BorderLayout.SOUTH);

        // Make the frame visible
        frame.setVisible(true);
    }

    public JTextField getCategoryField() {
        return categoryField;
    }

    public JButton getAddButton() {
        return addButton;
    }
}
