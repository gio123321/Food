package Model;

import Enum.FoodType;
import java.util.ArrayList;

public class Food {

    private int id;

    private ArrayList<Ingredient> ingredients;

    private String name;

    private FoodType foodtype;

    private String cooking_way;

    private String imagePath;

    public Food() {
    }

    public Food(int id, ArrayList<Ingredient> ingredients, String name, FoodType foodtype, String cooking_way, String imagePath) {
        this.id = id;
        this.ingredients = ingredients;
        this.name = name;
        this.foodtype = foodtype;
        this.cooking_way = cooking_way;
        this.imagePath = imagePath;
    }

    public Food(ArrayList<Ingredient> ingredients, String name, FoodType foodtype, String cooking_way, String imagePath) {
        this.ingredients = ingredients;
        this.name = name;
        this.foodtype = foodtype;
        this.cooking_way = cooking_way;
        this.imagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FoodType getFoodtype() {
        return foodtype;
    }

    public void setFoodtype(FoodType foodtype) {
        this.foodtype = foodtype;
    }

    public String getCooking_way() {
        return cooking_way;
    }

    public void setCooking_way(String cooking_way) {
        this.cooking_way = cooking_way;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + ingredients + " " + " " + foodtype + " " + cooking_way;
    }

}
