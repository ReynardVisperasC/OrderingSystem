package model;

public class CategoryModel{

    private static int idCounter = 0;
    private int id;
    private String categoryName;

    //lets create a contructor use to initialize value meaning it before running the program the initial values of the variables below is zero
    public CategoryModel(String categoryName){
        this.id = ++idCounter;
        this.categoryName = categoryName;
    }
    //getters ito ung kukuha ng value outside 
    public int getId(){
        return id;
    }
    public String getCategoryName(){
        return categoryName;
    }
    public void  setCategoryName(String categoryName){
        this.categoryName = categoryName;

    }

    @Override
    public String toString(){
        return  id + ". " + categoryName ;
    }

    public static void setIdCounter(int value){
        idCounter = value;
    }
}