package Dao;

import Model.Food;
import java.util.ArrayList;

public interface FoodDAO {
    void addFood(Food food);
    ArrayList<Food> getAllFoods();
}
