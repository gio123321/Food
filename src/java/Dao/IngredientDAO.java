package Dao;

import Model.Food;
import Model.Ingredient;
import java.util.ArrayList;

public interface IngredientDAO {
    void addIngredient(Ingredient ingredient);
    ArrayList<Ingredient> getAllIngredients();
}
