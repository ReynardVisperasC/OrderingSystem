public class CategoryModel {
    private static int idCounter = 0;
    private int id;
    private String categoryName;

    // Constructor
    public CategoryModel(String categoryName) {
        this.id = ++idCounter; // Auto-increment ID
        this.categoryName = categoryName;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + categoryName;
    }

    // Static method to set idCounter for file initialization
    public static void setIdCounter(int value) {
        idCounter = value;
    }
}
