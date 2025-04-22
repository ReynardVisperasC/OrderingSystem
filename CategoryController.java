import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class CategoryController {
    private List<CategoryModel> categories = new ArrayList<>();
    private final String fileName = "categories.txt";

    // Add a category
    public void addCategory(String categoryName) {
        // Check for duplicate category name
         for (CategoryModel category : categories) {
        if (category.getCategoryName().equals(categoryName)) {
            JOptionPane.showMessageDialog(null,
                "Category name \"" + categoryName + "\" already exists. Please use a unique name.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
        // If no duplicates, proceed to add the category
        CategoryModel category = new CategoryModel(categoryName);
        categories.add(category);
        saveCategoriesToFile();
        JOptionPane.showMessageDialog(null,
       "Category \"" + categoryName + "\" added successfully.",
        "Error",
        JOptionPane.INFORMATION_MESSAGE);
    return;
    }
    public void populateComboBox(JComboBox<String> comboBox) {
    comboBox.removeAllItems();  // Clear existing items
    comboBox.addItem("Select");
    for (CategoryModel category : categories) {
       
        comboBox.addItem(category.getCategoryName());  // Add category names
    }
}
public void reloadCategories() {
    categories.clear();  // Clear current list
    loadCategoriesFromFile();  // Reload data
}

    // Edit a category by ID
   // Edit a category by category name
// public void editCategory(String oldCategoryName, String newCategoryName) {
//     for (CategoryModel category : categories) {
//         if (category.getCategoryName().equalsIgnoreCase(oldCategoryName)) {
//             category.setCategoryName(newCategoryName);
//             saveCategoriesToFile();
//             System.out.println("Category name \"" + oldCategoryName + "\" updated to \"" + newCategoryName + "\".");
//             return;
//         }
//     }
//     System.out.println("Category name \"" + oldCategoryName + "\" not found.");
// }

public void editCategory(String oldCategoryName, String newCategoryName) {
    // Check if the new category name already exists
    for (CategoryModel category : categories) {
        if (category.getCategoryName().equalsIgnoreCase(newCategoryName)) {
            JOptionPane.showMessageDialog(null,
                "Category name \"" + newCategoryName + "\" already exists. Please use a unique name.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    // Find and update the category name
    for (CategoryModel category : categories) {
        if (category.getCategoryName().equalsIgnoreCase(oldCategoryName)) {
            category.setCategoryName(newCategoryName);
            saveCategoriesToFile();
            reloadCategories(); // Refresh category list
            JOptionPane.showMessageDialog(null,
                "Category name \"" + oldCategoryName + "\" updated to \"" + newCategoryName + "\" successfully.",
                "Success",
                JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    }

    JOptionPane.showMessageDialog(null,
        "Category name \"" + oldCategoryName + "\" not found.",
        "Error",
        JOptionPane.ERROR_MESSAGE);
}


    // Delete a category by ID
    public void deleteCategoryByName(String categoryName) {
        categories.removeIf(category -> category.getCategoryName().equalsIgnoreCase(categoryName));
        saveCategoriesToFile();
    }

    // Get all categories
    public List<CategoryModel> getAllCategories() {
        return categories;
    }

    // Save categories to a file
    private void saveCategoriesToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (CategoryModel category : categories) {
                writer.write(category.getId() + "," + category.getCategoryName());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving categories to file: " + e.getMessage());
        }
    }

    // Load categories from a file
    public void loadCategoriesFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int maxId = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String categoryName = parts[1];
                categories.add(new CategoryModel(categoryName)); // Add category
                maxId = Math.max(maxId, id); // Track the highest ID
            }
            CategoryModel.setIdCounter(maxId); // Set the counter to the highest ID
        } catch (IOException e) {
            System.out.println("Error loading categories from file: " + e.getMessage());
        }
    }
}
