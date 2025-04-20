import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryController {
    private List<CategoryModel> categories = new ArrayList<>();
    private final String fileName = "categories.txt";

    // Add a category
    public void addCategory(CategoryModel category) {
        categories.add(category);
        saveCategoriesToFile();
    }

    // Edit a category
    public void editCategory(int id, String newCategoryName) {
        for (CategoryModel category : categories) {
            if (category.getId() == id) {
                category.setCategoryName(newCategoryName);
                saveCategoriesToFile();
                return;
            }
        }
    }

    // Delete a category
    public void deleteCategory(int id) {
        categories.removeIf(category -> category.getId() == id);
        saveCategoriesToFile();
    }

    // Get all categories
    public List<CategoryModel> getAllCategories() {
        return categories;
    }

    // Save categories to a file
    public void saveCategoriesToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true))) {
            for (CategoryModel category : categories) {
                writer.write(category.getId() + "," + category.getCategoryName());
                writer.newLine();
                categories.clear();
                
            }
        } catch (IOException e) {
            System.out.println("Error saving categories to file: " + e.getMessage());
        }
    }
    // Load categories from a file
    public void loadCategoriesFromFile() {
       
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String categoryName = parts[1];
                categories.add(new CategoryModel(categoryName));
            }
        } catch (IOException e) {
            System.out.println("Error loading categories from file: " + e.getMessage());
        }
    }
}
