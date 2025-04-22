    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import javax.swing.*;
    import javax.swing.event.DocumentEvent;
    import javax.swing.event.DocumentListener;

    public class Category {
        
        public Category() {
            // Set up the frame
            CategoryController controller = new CategoryController();
            controller.loadCategoriesFromFile(); // Load existing data
            JFrame frame = new JFrame("Category Management");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
            
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setLayout(null); // Use null layout

            // Create two panels
            JPanel addPanel = new JPanel();
            addPanel.setBackground(Color.CYAN);
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
            AddButton.setEnabled(false);
            addPanel.add(AddButton);
            JPanel editdeletePanel = new JPanel();
            editdeletePanel.setBackground(Color.CYAN);
            editdeletePanel.setBounds(50, 50, 300, 250); // Set position and size
            editdeletePanel.setLayout(null);
// Create a dropdown for category selection
JComboBox<String> categoryDropdown = new JComboBox<>();
categoryDropdown.setBounds(50, 50, 200, 30);
editdeletePanel.add(categoryDropdown);

// Create a text field for editing
JTextField editField = new JTextField();
editField.setBounds(50, 90, 200, 30);
editdeletePanel.add(editField);

// Create Edit and Delete buttons
JButton editButton = new JButton("Edit");
editButton.setBounds(50, 130, 90, 30);
editdeletePanel.add(editButton);

JButton deleteButton = new JButton("Delete");
deleteButton.setBounds(160, 130, 90, 30);
editdeletePanel.add(deleteButton);

// Load existing categories into the dropdown
for (CategoryModel category : controller.getAllCategories()) {
    categoryDropdown.addItem(category.getCategoryName());
}

// Edit button functionality
editButton.addActionListener(e -> {
    String selectedCategory = (String) categoryDropdown.getSelectedItem();
    String newName = editField.getText().trim();
    if(selectedCategory.equals("Select")){
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);
    }
    if (newName.isEmpty()) {
        controller.editCategory(selectedCategory, newName);
        editField.setText("");
        controller.populateComboBox(categoryDropdown);
    }
});

// Delete button functionality
deleteButton.addActionListener(e -> {
    String selectedCategory = (String) categoryDropdown.getSelectedItem();
    controller.deleteCategoryByName(selectedCategory);
    categoryDropdown.removeItem(selectedCategory);
});

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
                controller.reloadCategories();
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
                    controller.populateComboBox(categoryDropdown); // Navigate to the Category GUI
                     // Dispose the current Menu window
                }
            });
            AddButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    
                        
                        String name = textField.getText();
                    
                        textField.setText("");
                        controller.addCategory(name);
                        
                        
                }
            });
            textField.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    toggleButton();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    toggleButton();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    toggleButton();
                }

                private void toggleButton() {
                    AddButton.setEnabled(!textField.getText().trim().isEmpty());
                }
            });
        }

        
    }
    // import java.util.Scanner;

    // public class Main {
    //     public static void main(String[] args) {
    //         CategoryController controller = new CategoryController();
    //         controller.loadCategoriesFromFile(); // Load existing data
    //         Scanner scanner = new Scanner(System.in);

    //         while (true) {
    //             System.out.println("\n1. Add Category");
    //             System.out.println("2. Edit Category");
    //             System.out.println("3. Delete Category");
    //             System.out.println("4. View Categories");
    //             System.out.println("5. Exit");
    //             System.out.print("Choose an option: ");

    //             int choice = scanner.nextInt();
    //             scanner.nextLine(); // Consume newline

    //             switch (choice) {
    //                 case 1 -> {
    //                     System.out.print("Enter category name: ");
    //                     String categoryName = scanner.nextLine();
    //                     controller.addCategory(categoryName);
    //                 }
    //                 case 2 -> {
    //                     System.out.print("Enter category ID to edit: ");
    //                     int id = scanner.nextInt();
    //                     scanner.nextLine(); // Consume newline
    //                     System.out.print("Enter new category name: ");
    //                     String newName = scanner.nextLine();
    //                     controller.editCategory(id, newName);
    //                 }
    //                 case 3 -> {
    //                     System.out.print("Enter category ID to delete: ");
    //                     int id = scanner.nextInt();
    //                     controller.deleteCategory(id);
    //                 }
    //                 case 4 -> {
    //                     System.out.println("Categories:");
    //                     for (CategoryModel category : controller.getAllCategories()) {
    //                         System.out.println(category);
    //                     }
    //                 }
    //                 case 5 -> {
    //                     System.out.println("Exiting...");
    //                     scanner.close();
    //                     return;
    //                 }
    //                 default -> System.out.println("Invalid option. Please try again.");
    //             }
    //         }
    //     }
    // }
